package com.wcs.library.repository;

import com.wcs.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findByAuthorContaining(String author);

    public List<Book> findByTitleContainingOrDescriptionContaining(String title, String description);

}
