package by.itechart;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class LibraryDB {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/mydb";
    static final String USER = "alex";
    static final String PASSWORD = "Maya666";
    private static List<Book> libraryFromDB = new LinkedList<>();

    public static List<Book> getLibraryFromDB() {
        return libraryFromDB;
    }

    public static void dataWork(List<Book> list) throws SQLException {

        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();

            for (Book book : list) {
                int id = book.getId();
                String author = book.getAuthor();
                String name = book.getName();
                statement.executeUpdate("INSERT INTO library VALUE (" + id + ", " + author + ", " + name);
        }
            LibraryFormation.library.clear();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM library");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String author = resultSet.getString("author");
                    String name = resultSet.getString("name");

                    Book book = new Book();
                    book.setId(id);
                    book.setName(name);
                    book.setAuthor(author);
                    libraryFromDB.add(book);
                }
                resultSet.close();
                statement.close();
                connection.close();
    }
}
