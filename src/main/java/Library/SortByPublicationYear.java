package Library;

import java.util.Comparator;

public class SortByPublicationYear implements Comparator<Book> {
    //sort publication year with ascending order.
    @Override
    public int compare(Book a, Book b) {
        return a.getPublicationYear().compareTo(b.getPublicationYear());
    }
}
