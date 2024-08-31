package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void addBookTest(){
        Book book = new Book("example title","pepe","1717263847194");
        Library library = new Library();
        assertTrue(library.addBook(book));
    }

    @Test
    public void loanABookTest(){
        String userId = "1";
        String isbn = "1717263847194";
        Book book = new Book("example title","pepe",isbn);
        User user = new User();


        user.setId(userId);
        user.setName("pepito");
        Library library = new Library();
        library.addBook(book);
        library.addUser(user);

        assertNotNull(library.loanABook(userId,isbn));
    }
}
