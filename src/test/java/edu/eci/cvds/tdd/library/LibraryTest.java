package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
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
        Library library = createExampleLibrary(userId, isbn);
        assertNotNull(library.loanABook(userId,isbn));
    }
    private Library createExampleLibrary(String userId, String isbn){
        Book book = new Book("example title","pepe",isbn);
        User user = new User();
        user.setId(userId);
        user.setName("pepito");
        Library library = new Library();
        library.addBook(book);
        library.addUser(user);
        return library;
    }

    private Loan addLoanToLibrary(Library library){
        String userId = "1";
        String isbn = "1717263847194";
        return library.loanABook(userId,isbn);
    }

    @Test
    public void returnLoanTest(){
        String userId = "1";
        String isbn = "1717263847194";
        Library library = createExampleLibrary(userId,isbn);
        Loan loan = addLoanToLibrary(library);
        assertNotNull(library.returnLoan(loan));
    }
}
