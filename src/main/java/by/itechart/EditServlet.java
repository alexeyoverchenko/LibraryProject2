package by.itechart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {
static int updateId;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        updateId = Integer.parseInt(req.getParameter("id"));
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
            LibraryDAO.dataRedact(updateId, author, name);
            req.getRequestDispatcher("/forwardToBook.jsp").forward(req, resp);
        }
    }
}
