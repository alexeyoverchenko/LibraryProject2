package by.itechart;

import lombok.SneakyThrows;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {
    static boolean isFirstResponse = true;
    static int slider = 0;
    static int fieldStatus = 1;

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        if (isFirstResponse) {
            isFirstResponse = false;
            PaginationService.dataProcess(1);
        }

        PaginationService.dataProcess(fieldStatus);
        PaginationService.pagesCount();
        request.setAttribute("pageNumber", PaginationService.getPagesNumber());
        request.setAttribute("pageLimit", PaginationService.getPagesLimit());
        request.setAttribute("library", PaginationService.getPaginationList());
        request.getRequestDispatcher("/book.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String action_button = request.getParameter("action_button");

        if("set".equals(action)) {
            request.setAttribute("pageLimit", PaginationService.getPagesLimit());
            PaginationService.setPagesLimit(Integer.parseInt(request.getParameter("lines_number")));
        }

        if ("first".equals(action_button)) {
            fieldStatus = Integer.parseInt(request.getParameter("page"));
            request.setAttribute("slider", slider);
        } else if ("second".equals(action_button)) {
            fieldStatus = Integer.parseInt(request.getParameter("page"));
            request.setAttribute("slider", slider);
        } else if ("third".equals(action_button)) {
            fieldStatus = Integer.parseInt(request.getParameter("page"));
            request.setAttribute("slider", slider);
        } else if ("back".equals(action_button)) {
            if(!(slider <= 0)) {
                slider += -1;
                request.setAttribute("slider", slider);
            }
        } else if ("next".equals(action_button)) {
            if(!((fieldStatus+2) >= PaginationService.getPagesNumber())) {
                slider += +1;
                request.setAttribute("slider", slider);
            }
        }

        if ("delete".equals(action)) {
            int deleteId = Integer.parseInt(request.getParameter("id"));
            LibraryDAO.dataDelete(deleteId);
            PaginationService.pagesCount();
        }

        if ("save".equals(action)) {
            request.getParameterMap();

            LibraryFormation.saveNewBook(request.getParameter("author"),request.getParameter("name"));
            PaginationService.pagesCount();
        }

        PaginationService.dataProcess(fieldStatus);
        PaginationService.pagesCount();
        request.setAttribute("pageNumber", PaginationService.getPagesNumber());
        request.setAttribute("pageLimit", PaginationService.getPagesLimit());
        request.setAttribute("library", PaginationService.getPaginationList());

        request.getRequestDispatcher("/book.jsp").forward(request, response);
    }
}