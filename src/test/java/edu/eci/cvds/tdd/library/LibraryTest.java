package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void addBookTest(){
        Book book = new Book("example title","pepito ","1717263847194");
        Library library = new Library();
        assertTrue(library.addBook(book));
    }
}
