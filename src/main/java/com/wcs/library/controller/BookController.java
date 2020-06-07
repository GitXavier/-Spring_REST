package com.wcs.library.controller;


import com.wcs.library.Service.BookService;
import com.wcs.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired BookService bookService;

    @GetMapping
    public List<Book> getAllBook() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PostMapping
    public Book creatBook(@RequestBody Book book) {
        return bookService.creatBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("{id}")
    public boolean deleteBook(@PathVariable Long id) {
          return bookService.deleteBook(id);
    }

    @PostMapping("/search")
    public List<Book> searchBook(@RequestBody Map<String, String> searchData) {
        return bookService.searchBook(searchData);
    }
}
