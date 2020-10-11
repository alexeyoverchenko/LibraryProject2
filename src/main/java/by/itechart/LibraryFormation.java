package by.itechart;

import java.util.LinkedList;
import java.util.List;

public class LibraryFormation {
    public static List<Book> library = new LinkedList<>();

    public static void saveNewBook(String author, String name) {
        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        library.add(book);
        LibraryDB.dataWrite(library);

    }
}
