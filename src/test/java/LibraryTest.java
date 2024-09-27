package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;

    public void setUp() {
        library = new Library(); // Initialize library before each test
    }

    @Test
    public void testAddBook() {
        Book book = new Book("12345", "Test Book", "Test Author", 2023, 3);
        library.addBook(book);
        assertDoesNotThrow(() -> library.borrowBook("12345"));
    }
    
//    To check for adding of duplicate books
    @Test
    public void testAddingDuplicateBook() {
        Book book = new Book("12345", "Test Book", "Test Author", 2023, 2);
        library.addBook(book);

        Book duplicateBook = new Book("12345", "Test Book", "Test Author", 2023, 3);
        library.addBook(duplicateBook);

        Book storedBook = library.getBookByISBN("12345");
        assertEquals(5, storedBook.getTotalCopies()); // Ensure total copies have increased
        assertEquals(5, storedBook.getAvailableCopies()); // Ensure available copies have increased
    }
    
    @Test
    public void testBorrowBook() {
        Book book = new Book("12345", "Test Book", "Test Author", 2023, 3);
        library.addBook(book);
        library.borrowBook("12345");

        assertEquals(2, book.getAvailableCopies()); // Check if available copies decrease
        assertTrue(book.isAvailable()); // Still available because copies remain
    }
    
    @Test
    public void testBorrowAllCopies() {
        Book book = new Book("12345", "Test Book", "Test Author", 2023, 2);
        library.addBook(book);

        library.borrowBook("12345"); // Borrow first copy
        library.borrowBook("12345"); // Borrow second copy

        assertFalse(book.isAvailable()); // No copies should be left
        assertEquals(0, book.getAvailableCopies()); // All copies borrowed
    }

    @Test
    public void testReturnBook() {
        Book book = new Book("12345", "Test Book", "Test Author", 2023, 1);
        library.addBook(book);
        library.borrowBook("12345");
        library.returnBook("12345");

        assertTrue(book.isAvailable());
        assertEquals(1, book.getAvailableCopies()); // Verify available copies have increased
    }
    
    @Test
    public void testViewAvailableBooks() {
        Book book1 = new Book("12345", "Test Book 1", "Test Author", 2023, 1);
        Book book2 = new Book("67890", "Test Book 2", "Test Author", 2023, 2);
        library.addBook(book1);
        library.addBook(book2);
        library.borrowBook("67890");

        // Ensure both books are listed as available
        library.viewAvailableBooks();
    }
    
    public static void main(String[] args) {
        LibraryTest obj = new LibraryTest();
        int ctr = 0; // to count the number of tests passed

        // Manually call setUp() before each test to initialize the library
        try {
            obj.setUp(); // Initialize for each test
            obj.testAddBook();
            System.out.println("Unit Test for Adding Books Successful");
            ctr++;
        } catch (Exception e) {
            System.out.println("Unit Test for Adding Books Failed");
        }

        try {
            obj.setUp();
            obj.testAddingDuplicateBook();
            System.out.println("Unit Test for Duplicate Book Handling Successful");
            ctr++;
        } catch (Exception e) {
            System.out.println("Unit Test for Duplicate Book Handling Failed");
        }
        
        try {
            obj.setUp();
            obj.testBorrowBook();
            System.out.println("Unit Test for Borrowing Books with Multiple Copies Successful");
            ctr++;
        } catch (Exception e) {
            System.out.println("Unit Test for Borrowing Books with Multiple Copies Failed");
        }
        
        try {
            obj.setUp();
            obj.testBorrowAllCopies();
            System.out.println("Unit Test for Borrowing All Copies Successful");
            ctr++;
        } catch (Exception e) {
            System.out.println("Unit Test for Borrowing All Copies Failed");
        }
        
        try {
            obj.setUp();
            obj.testReturnBook();
            System.out.println("Unit Test for Returning Books Successful");
            ctr++;
        } catch (Exception e) {
            System.out.println("Unit Test for Returning Books Failed");
        }
        
        try {
            obj.setUp();
            obj.testViewAvailableBooks();
            System.out.println("Unit Test for Displaying Available Books Successful");
            ctr++;
        } catch (Exception e) {
            System.out.println("Unit Test for Displaying Available Books Failed");
        }
        
        System.out.println("Total Unit Tests Passed: " + ctr);
    }
}