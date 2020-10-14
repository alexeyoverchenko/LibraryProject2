package by.itechart;

import java.util.LinkedList;
import java.util.List;

public class PaginationService {
    private static List<Book> library = LibraryDAO.dataRead();
    private static List<Book> paginationList = new LinkedList<>();
    private static int pagesNumber;
    private static int pagesLimit;

    public static void setPagesLimit(int pagesLimit) {
        PaginationService.pagesLimit = pagesLimit;
    }
    public static List<Book> getLibrary() {
        return library;
    }
    public static List<Book> getPaginationList() {
        return paginationList;
    }

    public static int getPagesNumber() {
        return pagesNumber;
    }

    public static void pagesCount() {
        double pages = (double) getLibrary().size() / pagesLimit;
        if (pages >= 0 & pages <= 1) {
            pagesNumber = 1;
        } else if (pages % 10 == 0) {
            pagesNumber = (int) pages;
        } else {
            pagesNumber = (int) pages + 1;
        }
    }

    public static void dataProcess(int action_button) {
        PaginationService.pagesCount();
        getPaginationList().clear();
        for (int i = (action_button * pagesLimit) - pagesLimit; i < (action_button * pagesLimit); i++) {
            paginationList.add(library.get(i));
        }
    }
}
