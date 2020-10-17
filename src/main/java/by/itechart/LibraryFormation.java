package by.itechart;

import java.util.*;

public class LibraryFormation {
    public static List<Book> library = new LinkedList<>();

    public static void saveNewBook(List list) {
        int secondHalf = list.size() / 2;
        for (int i = 0; i < secondHalf; i++) {
            String author = list.get(i).toString();
            String name = list.get(i + secondHalf).toString();
            if (author.equals("") | name.equals("")) break;
            Book book = new Book();
            book.setAuthor(author);
            book.setName(name);
            library.add(book);
            LibraryDAO.dataWrite(library);
        }
    }
}
