package by.itechart;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

//        String action = request.getParameter("action");
//        if ("submit".equals(action)) {
//            request.setAttribute("library", LibraryDB.dataDelete(Integer.parseInt(request.getParameter("id"))));
//        }

//        if ("submit".equals(action)) {
        LibraryFormation.saveNewBook(request.getParameter("author"),request.getParameter("name"));
        request.setAttribute("library", LibraryDB.dataRead());
//        }

        request.getRequestDispatcher("/book.jsp").forward(request, response);
    }

}