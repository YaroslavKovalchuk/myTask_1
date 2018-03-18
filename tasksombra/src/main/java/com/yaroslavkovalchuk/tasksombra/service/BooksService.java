package com.yaroslavkovalchuk.tasksombra.service;

import com.yaroslavkovalchuk.tasksombra.dto.request.BooksRequest;
import com.yaroslavkovalchuk.tasksombra.dto.response.BooksResponse;

import java.util.List;

public interface BooksService {

    BooksResponse save(BooksRequest booksRequest);
    BooksResponse update(Long id, BooksRequest booksRequest);
    void delete(Long id);
    List<BooksResponse> getAll();
    BooksResponse getOne(Long id);

    Long countBooksByGenre(String genre);
    List<BooksResponse> authorHasBooks();

}
