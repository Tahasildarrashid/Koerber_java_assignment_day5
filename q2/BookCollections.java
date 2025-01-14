package src_assignment_day5.q2;

import java.util.*;

public class BookCollections implements Comparator<BookCollections> {
    private int id;
    private String title;
    private String owner;
    List<BookCollections> arr;

    public BookCollections() {
        this.arr = new ArrayList<>();
    }

    public BookCollections(int id, String title, String owner) {
        this.id = id;
        this.title = title;
        this.owner = owner;
    }

    public void init() {
        arr.add(new BookCollections(1, "Java in Depth", "Gosling"));
        arr.add(new BookCollections(2, "Game of thrones", "Robert J"));
        arr.add(new BookCollections(3, "Stranger things", "Roosevelt"));
        arr.add(new BookCollections(4, "Squid Game", "Hyuong je hun"));
        arr.add(new BookCollections(5, "Wednesday", "Robert J"));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void display() {
        for (BookCollections b : arr) {
            System.out.println("Id: " + b.id + " Title: " + b.title + " Owner: " + b.owner);
        }
    }

    public boolean hasBook(BookCollections b) {
        for (BookCollections book : arr) {
            if (book.title.equalsIgnoreCase(b.title) && book.owner.equalsIgnoreCase(b.owner)) {
                return true;
            }
        }
        return false;
    }

    // Sort the books by title and then by owner
    public void sort() {
        Collections.sort(arr, this);
    }

    @Override
    public int compare(BookCollections b1, BookCollections b2) {
        int titleComparison = b1.title.compareTo(b2.title);
        if (titleComparison != 0) {
            return titleComparison;
        }
        return b1.owner.compareTo(b2.owner);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookCollections that = (BookCollections) o;
        return Objects.equals(title, that.title) && Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, owner);
    }
}