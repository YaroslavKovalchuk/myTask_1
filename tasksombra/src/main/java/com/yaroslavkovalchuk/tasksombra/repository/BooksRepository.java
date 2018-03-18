package com.yaroslavkovalchuk.tasksombra.repository;

import com.yaroslavkovalchuk.tasksombra.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BooksRepository extends JpaRepository<Books,Long> {

    Long countBooksByGenre(String genre);

    @Query("select b from Books b inner join fetch b.authors as a where a.books.size> 1")
    List<Books> booksAuthorHasBooks();


}
