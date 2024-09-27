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

        
        System.out.println("Total Unit Tests Passed: " + ctr);
    }
}