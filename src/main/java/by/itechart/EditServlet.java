package by.itechart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {
    static int updateId;
    static String pagesPath;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateId = Integer.parseInt(req.getParameter("id"));
        pagesPath = "http://localhost:8080/edit?id=" + updateId;
        if (updateId != 0) {
            req.getRequestDispatcher("/edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("update".equals(action)) {
            String author = req.getParameter("author_new");
            String name = req.getParameter("name_new");
            if (author.equals("") | name.equals("")) {
                req.setAttribute("id", updateId);
                req.getRequestDispatcher("refresh.jsp").forward(req, resp);
            }
            LibraryDAO.dataRedact(updateId, author, name);
        }
        req.getRequestDispatcher("/forwardToBook.jsp").forward(req, resp);
    }
}

