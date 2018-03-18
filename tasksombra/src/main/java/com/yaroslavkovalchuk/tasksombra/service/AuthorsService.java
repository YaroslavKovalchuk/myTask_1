package com.yaroslavkovalchuk.tasksombra.service;

import com.yaroslavkovalchuk.tasksombra.dto.request.AuthorRequest;
import com.yaroslavkovalchuk.tasksombra.dto.response.AuthorsResponse;
import com.yaroslavkovalchuk.tasksombra.entity.Authors;

import java.util.List;

public interface AuthorsService {

    AuthorsResponse save(AuthorRequest authorRequest);
    AuthorsResponse update(Long id, AuthorRequest authorRequest);
    void delete(Long id);
    List<AuthorsResponse> getAll();
    AuthorsResponse getOne(Long id);

   AuthorsResponse maxBooks();
   List<AuthorsResponse> getAuthorsOlderThen(Integer age);

}
