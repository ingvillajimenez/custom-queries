package com.skillsoft.springdatajpa.repository;

import com.skillsoft.springdatajpa.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAllNamedQuery();

    List<Book> findByTitleNamedQuery(String title);

    @Query(nativeQuery = true)
    List<Book> findByAuthorNativeNamedQuery(@Param("author")String author);

    List<Book> findAllXML();

    List<Book> findByMinRatingXML(int minRating);

    @Query(nativeQuery = true)
    List<Book> findByAuthorNativeXML(@Param("author")String author);

    List<Book> findAvailableBooksJPQL();

    List<Book> findByRatingJPQL(int minRating);

    @Query(nativeQuery = true)
    List<Book> findByTitleNative(@Param("title")String title);
}
