package org.example;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    // Add a new book to the library or increase copies if the book already exists
    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
//            Book existingBook = books.get(book.getIsbn());
            books.get(book.getIsbn()).setAvailableCopies(books.get(book.getIsbn()).getAvailableCopies()+book.getAvailableCopies());
            books.get(book.getIsbn()).setTotalCopies(books.get(book.getIsbn()).getTotalCopies()+book.getTotalCopies());
//            existingBook.returnBook(); // Simulating adding more copies
        } else {
            books.put(book.getIsbn(), book);
        }
    }
}