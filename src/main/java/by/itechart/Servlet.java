package by.itechart;

import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {
static boolean isFirstResponse = true;
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        PaginationService.setPagesLimit(4);
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

        if ("first".equals(action_button)) {
            PaginationService.dataProcess(Integer.parseInt(request.getParameter("page")));
        } else if ("second".equals(action_button)) {
            PaginationService.dataProcess(Integer.parseInt(request.getParameter("page")));
        }

        if ("delete".equals(action_button)) {
            LibraryDAO.dataDelete(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("library", LibraryDAO.dataRead());
        }

        if ("save".equals(action)) {
            LibraryFormation.saveNewBook(request.getParameter("author"),request.getParameter("name"));
            request.setAttribute("library", LibraryDAO.dataRead());
        }

        request.setAttribute("pageNumber", PaginationService.getPagesNumber());
        request.setAttribute("library", PaginationService.getPaginationList());
        request.getRequestDispatcher("/book.jsp").forward(request, response);
    }


}