package by.itechart;

import java.util.*;

public class LibraryFormation {
    public static List<Book> library = new LinkedList<>();

    public static void saveNewBook(String author, String name) {
        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        library.add(book);
        LibraryDAO.dataWrite(library);

    }


}
