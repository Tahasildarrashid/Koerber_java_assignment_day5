package src_assignment_day5.q2;

import java.io.*;
import java.util.*;

public class Book {
    public static void main(String[] args) {
        BookCollections b = new BookCollections();
        b.init();
        b.display();
        BookCollections b1 = new BookCollections(1, "Java in Depth", "Gosling");
        if(b.hasBook(b1))
            System.out.println("Book found in the collection");
        else
            System.out.println("Book not found");
        b.sort();
        b.display();
    }
}
