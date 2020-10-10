package by.itechart;

import lombok.SneakyThrows;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("library", LibraryDB.dataRead());
        request.getRequestDispatcher("/book.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        request.setCharacterEncoding("UTF-8");
        LibraryFormation.saveNewBook(Integer.parseInt(request.getParameter("id")), request.getParameter("author"),request.getParameter("name"));

        request.setAttribute("library", LibraryDB.dataRead());
        request.getRequestDispatcher("/book.jsp").forward(request, response);
    }
}