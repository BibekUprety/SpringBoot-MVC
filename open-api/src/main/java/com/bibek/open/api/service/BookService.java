package com.bibek.open.api.service;

import com.bibek.open.api.exception.BookIdMismatchException;
import com.bibek.open.api.exception.BookNotFoundException;
import com.bibek.open.api.model.Book;
import com.bibek.open.api.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book getAllBook() {
        return (Book) bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {

        if (book.getId() != id){
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }

    public void deleteUser(Long id) {
         bookRepository.deleteById(id);
    }
}
