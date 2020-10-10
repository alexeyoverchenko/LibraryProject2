package by.itechart;

import lombok.SneakyThrows;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class LibraryDB {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/mydb";
    static final String USER = "alex";
    static final String PASSWORD = "Maya666";

    @SneakyThrows
    public static void dataWrite(List<Book> library){
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        for (Book book : library) {
            int id = book.getId();
            String author = book.getAuthor();
            String name = book.getName();
            statement.executeUpdate("INSERT INTO library VALUES (" + id + ", " + author + ", " + name + " )");
        }
        LibraryFormation.library.clear();
        statement.close();
        connection.close();
    }

    @SneakyThrows
    public static List<Book> dataRead(){
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
                    book.setName(name);
                    book.setAuthor(author);
                    list.add(book);
                }
        resultSet.close();
        statement.close();
        return list;
    }
}
