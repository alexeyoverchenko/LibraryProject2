package by.itechart;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class LibraryDAO {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/mydb";
    static final String USER = "alex";
    static final String PASSWORD = "Maya666";

    @SneakyThrows
    public static void dataWrite(List<Book> library) {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        for (Book book : library) {
            statement.executeUpdate("INSERT INTO library (author, name) VALUES (\"" + book.getAuthor() + "\", \"" + book.getName() + "\")");
            LibraryFormation.library.clear();
            statement.close();
            connection.close();
        }
    }

    @SneakyThrows
    public static List<Book> dataRead() {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM library");
        List<Book> list = new LinkedList();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String author = resultSet.getString("author");
            String name = resultSet.getString("name");

            Book book = new Book();
            book.setId(id);
            book.setAuthor(author);
            book.setName(name);
            list.add(book);
        }
        resultSet.close();
        statement.close();
        return list;
    }

    @SneakyThrows
    public static void dataDelete(int id) {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();

        statement.executeUpdate("DELETE FROM library WHERE id = " + id);
        dataRead();
    }
}
