package by.itechart;

import javax.servlet.http.HttpServlet;
import java.sql.SQLException;

public class StartClass extends HttpServlet {
    public static LibraryDB libraryDB = new LibraryDB();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        libraryDB.dataWork();

    }


}
