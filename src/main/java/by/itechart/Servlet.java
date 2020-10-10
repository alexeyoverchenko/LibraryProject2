package by.itechart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.setAttribute("library", LibraryDB.getLibraryFromDB());
            request.getRequestDispatcher("/book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("submit".equals(action)) {
            try {
                LibraryFormation.saveNewBook(Integer.parseInt(request.getParameter("id")), request.getParameter("author"),request.getParameter("name"));
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }

        request.setAttribute("library", LibraryDB.getLibraryFromDB());
        request.getRequestDispatcher("/book.jsp").forward(request, response);
    }
}