package com.example.graphql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @QueryMapping
    public List<Book> books() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book bookById(@Argument("id") String id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    // ==================== Mutation Operations ====================
    @MutationMapping
    public Book createBook(@Argument("book") BookRequest bookInput) {
        Book book = new Book();
        book.setName(bookInput.name());
        book.setPageCount(bookInput.pageCount());
        book.setAuthor(new Author(null,bookInput.author().firstName(), bookInput.author().lastName()));
        return bookRepository.save(book);
    }

    @MutationMapping
    public Book updateBook(@Argument("id") String id, @Argument("book") BookRequest bookInput) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setName(bookInput.name());
            book.setPageCount(bookInput.pageCount());
            book.setAuthor(new Author(null,bookInput.author().firstName(), bookInput.author().lastName()));
            return bookRepository.save(book);
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteBook(@Argument("id") String id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
