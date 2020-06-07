package com.wcs.library.Service;

import com.wcs.library.entity.Book;
import com.wcs.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book getById(@PathVariable Long id) {
        return this.bookRepository.findById(id).get();
    }

    public Book creatBook(@RequestBody Book book) {
        return this.bookRepository.save(book);
    }

    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {

        Book existingBook = this.bookRepository.findById(id).get();

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setDescription(book.getDescription());

        return this.bookRepository.save(existingBook);
    }

    public boolean deleteBook(@PathVariable Long id) {

        bookRepository.deleteById(id);
        return true;
    }

    public List<Book> searchBook(@RequestBody Map<String, String> search) {
        String searchData = search.get("text");

        return bookRepository.findByTitleContainingOrDescriptionContaining(searchData, searchData);
    }


}
