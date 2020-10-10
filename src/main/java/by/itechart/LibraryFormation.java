package by.itechart;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LibraryFormation {
    private static List<Book> library = new LinkedList<Book>();

    public List<Book> getLibrary() {
        return library;
    }


    public void saveNewBook(int id, String name, String author){
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        library.add(book);
//        StartClass.libraryDB.writeToData(library);

    }

}
