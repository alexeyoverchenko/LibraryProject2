package by.itechart;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends HttpServlet {
    LibraryFormation libraryFormation = new LibraryFormation();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        libraryFormation.saveNewBook(1, "Так говорил заратустра", "Ницше");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("library", libraryFormation.getLibrary());
            request.getRequestDispatcher("/book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("submit".equals(action)) {
            libraryFormation.saveNewBook(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),request.getParameter("author"));
        }

        request.setAttribute("library", libraryFormation.getLibrary());
        request.getRequestDispatcher("/book.jsp").forward(request, response);
    }
}