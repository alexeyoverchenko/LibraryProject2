package by.itechart;

import java.util.LinkedList;
import java.util.List;

public class LibraryFormation {
    public static List<Book> library = new LinkedList<>();

    public static void saveNewBook(String name, String author) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        library.add(book);
        LibraryDB.dataWrite(library);

    }
}
