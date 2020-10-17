package by.itechart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/edit.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action_update");

        if ("update".equals(action)) {
//            int id = Integer.parseInt(request.getParameter("id"));
            String author = request.getParameter("author_new");
            String name = request.getParameter("name_new");
            LibraryDAO.dataRedact(Servlet.updateId, author, name);

            request.getRequestDispatcher("/bookForward.jsp").forward(request, response);
        }

        request.getRequestDispatcher("/edit.jsp").forward(request, response);

    }
}
