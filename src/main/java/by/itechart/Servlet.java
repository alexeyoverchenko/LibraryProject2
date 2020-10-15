package by.itechart;

import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {
static boolean isFirstResponse = true;
static int editID = 0;
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        if (isFirstResponse) {
            isFirstResponse = false;
            PaginationService.dataProcess(1);
        }
        request.setAttribute("pageNumber", PaginationService.getPagesNumber());
        request.setAttribute("library", PaginationService.getPaginationList());
        request.getRequestDispatcher("/book.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String action_button = request.getParameter("action_button");
        int fieldStatus = 1;

        if("set".equals(action)) {
            PaginationService.setPagesLimit(Integer.parseInt(request.getParameter("lines_number")));
        }

        if ("first".equals(action_button)) {
            fieldStatus = Integer.parseInt(request.getParameter("page"));
        } else if ("second".equals(action_button)) {
            fieldStatus = Integer.parseInt(request.getParameter("page"));
        }

        if ("delete".equals(action)) {
            int deleteId = Integer.parseInt(request.getParameter("id"));
            LibraryDAO.dataDelete(deleteId);
            PaginationService.pagesCount();
        }

        if ("save".equals(action)) {
            LibraryFormation.saveNewBook(request.getParameter("author"),request.getParameter("name"));
            PaginationService.pagesCount();
        }

        if ("edit".equals(action)) {
            editID = Integer.parseInt(request.getParameter("id"));
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        }
        if ("update".equals(action)) {
            String author = request.getParameter("author_new");
            String name = request.getParameter("name_new");
            LibraryDAO.dataRedact(editID, author, name);
        }

        PaginationService.dataProcess(fieldStatus);
        request.setAttribute("pageNumber", PaginationService.getPagesNumber());
        request.setAttribute("library", PaginationService.getPaginationList());
        request.getRequestDispatcher("/book.jsp").forward(request, response);
    }


}