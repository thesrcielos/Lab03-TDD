package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Library responsible for manage the loans and the users.
 */
public class Library {

    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }

    /**
     * Adds a new {@link edu.eci.cvds.tdd.library.book.Book} into the system, the book is store in a Map that contains
     * the {@link edu.eci.cvds.tdd.library.book.Book} and the amount of books available, if the book already exist the
     * amount should increase by 1 and if the book is new the amount should be 1, this method returns true if the
     * operation is successful false otherwise.
     *
     * @param book The book to store in the map.
     *
     * @return true if the book was stored false otherwise.
     */
    public boolean addBook(Book book) {
        //Miguel implementation
        boolean res = true;
        try{
            if (books.containsKey(book)){
                books.put(book,books.get(book)+1);
            } else {
                books.put(book, 1);
            }
        } catch (Exception e){
            res = false;
        }
        return  res;
    }

    /**
     * This method creates a new loan with for the User identify by the userId and the book identify by the isbn,
     * the loan should be store in the list of loans, to successfully create a loan is required to validate that the
     * book is available, that the user exist and the same user could not have a loan for the same book
     * {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE}, once these requirements are meet the amount of books is
     * decreased and the loan should be created with {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE} status and
     * the loan date should be the current date.
     *
     * @param userId id of the user.
     * @param isbn book identification.
     *
     * @return The new created loan.
     */
    public Loan loanABook(String userId, String isbn) {
        //Diego implementation
        Book book = findBookByIsbn(isbn);
        User user = findUserById(userId);
        if(book == null || user == null){
            return null;
        }
        boolean userHasALoan = userHasALoanWithThatBook(book,user);
        if (books.get(book) < 1 || userHasALoan){
            return null;
        }
        books.put(book, books.get(book)-1);
        Loan loan = new Loan();
        loan.setBook(book);
        loan.setUser(user);
        loan.setStatus(LoanStatus.ACTIVE);
        loan.setLoanDate(LocalDateTime.now());
        loans.add(loan);
        return loan;

    }

    /**
     * This method return a loan, meaning that the amount of books should be increased by 1, the status of the Loan
     * in the loan list should be {@link edu.eci.cvds.tdd.library.loan.LoanStatus#RETURNED} and the loan return
     * date should be the current date, validate that the loan exist.
     *
     * @param loan loan to return.
     *
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        //Miguel and Diego implementation
        Book book = loan.getBook();
        User user = loan.getUser();
        Loan loanRetrieved = findLoanByUserIdAndBookIsbn(user,book);
        if (loanRetrieved == null) return null;
        loanRetrieved.setStatus(LoanStatus.RETURNED);
        Book loanBook = loanRetrieved.getBook();
        books.put(loanBook, books.get(loanBook)+1);
        return loan;
    }

    private User findUserById(String userId){
        return users.stream().filter(user -> user.getId()
                .equals(userId)).findFirst().orElse(null);
    }

    private Book findBookByIsbn(String isbn){
        return books.keySet().stream().filter(book -> book.getIsbn().equals(isbn))
                .findFirst().orElse(null);
    }

    private boolean userHasALoanWithThatBook(Book book, User user){
        return loans.stream()
                .anyMatch(loan -> loan.getBook().equals(book)
                        && loan.getUser().equals(user)
                        && loan.getStatus().equals(LoanStatus.ACTIVE)
                );
    }

    private Loan findLoanByUserIdAndBookIsbn(User user, Book book){
        return loans.stream().filter(loan -> loan.getUser().equals(user)
                        && loan.getBook().equals(book)
                        && loan.getStatus().equals(LoanStatus.ACTIVE))
                .findFirst().orElse(null);
    }
    public boolean addUser(User user) {
        return users.add(user);
    }

}