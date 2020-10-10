package by.itechart;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LibraryFormation {
    public static List<Book> library = new LinkedList<>();

    public static void saveNewBook(int id, String name, String author) throws SQLException {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        library.add(book);
        LibraryDB.dataWork(library);

    }

}
