package com.pndev.library.repository;

import com.pndev.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRespository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);

    List<Book> findByAuthorContainingIgnoreCase (String author);

    List <Book> findByPublicationYearBetween (int startYear, int endYear);

    @Query ("SELECT b FROM Book b WHERE b.available = true")
    List<Book> findAvailableBooks();

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Book> searchByTitleKeyword(@Param("keyword") String keyword);

    boolean existsByTitleAndAuthor (String title, String author);
}
