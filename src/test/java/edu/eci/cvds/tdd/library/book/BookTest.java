package edu.eci.cvds.tdd.library.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BookTest {
    @Test
    public void bookTest(){
        String title = "exxample title";
        String author = "pepe writer";
        String isbn = "123456789098";
        Book book = new Book(title, author, isbn);
        assertEquals(title,book.getTittle());
        assertEquals(author,book.getAuthor());
        assertEquals(isbn,book.getIsbn());
    }
}
