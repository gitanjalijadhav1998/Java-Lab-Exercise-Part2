package Library;

import java.util.Comparator;

public class SortByAverageRating implements Comparator<Book> {
    //sort average rating with ascending order.

    @Override
    public int compare(Book a, Book b) {
        return a.getAverageRating().compareTo(b.getAverageRating());
    }

}
