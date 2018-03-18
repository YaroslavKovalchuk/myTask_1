package com.yaroslavkovalchuk.tasksombra.service.impl;

import com.yaroslavkovalchuk.tasksombra.dto.request.AuthorRequest;
import com.yaroslavkovalchuk.tasksombra.dto.response.AuthorsResponse;
import com.yaroslavkovalchuk.tasksombra.entity.Authors;
import com.yaroslavkovalchuk.tasksombra.entity.Books;
import com.yaroslavkovalchuk.tasksombra.repository.AuthorsRepository;
import com.yaroslavkovalchuk.tasksombra.repository.BooksRepository;
import com.yaroslavkovalchuk.tasksombra.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorsServiceImpl implements AuthorsService {

    @Autowired
    private AuthorsRepository authorsRepository;

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public AuthorsResponse save(AuthorRequest authorRequest) {
        Authors authors = new Authors();
        authors.setName(authorRequest.getName());
        authors.setBorn(authorRequest.getBorn());
        authors.setGender(authorRequest.getGender());
        addBooks(authorRequest,authors);

        return new AuthorsResponse(authorsRepository.save(authors));
    }

    @Override
    public AuthorsResponse update(Long id, AuthorRequest authorRequest) {

        Authors authors = authorsRepository.findOne(id);

        if(authorRequest.getName() != null){authors.setName(authorRequest.getName()); }
        if(authorRequest.getBorn() != null){authors.setBorn(authorRequest.getBorn()); }
        if(authorRequest.getGender() != null){authors.setGender(authorRequest.getGender());}
        addBooks(authorRequest,authors);

        return new AuthorsResponse(authorsRepository.save(authors));

    }

    @Override
    public void delete(Long id) {
        authorsRepository.delete(id);
    }

    @Override
    public List<AuthorsResponse> getAll() {
        List<Authors> authors= authorsRepository.findAll();
        List<AuthorsResponse> authorsResponses= new ArrayList<>();
        for(Authors author:authors){
            authorsResponses.add(new AuthorsResponse(author));
        }
        return authorsResponses;
    }

    @Override
    public AuthorsResponse getOne(Long id) {
        return new AuthorsResponse(authorsRepository.findOne(id));
    }

    @Override
    public AuthorsResponse maxBooks() {
        return new AuthorsResponse(authorsRepository.maxBooks());
    }

    @Override
    public List<AuthorsResponse> getAuthorsOlderThen( Integer age) {
        List<Authors> authorsList = authorsRepository.getAuthorsOlderThen(age);
        List<AuthorsResponse> authorsResponseList = new ArrayList<>();
        for (Authors authors: authorsList){
            authorsResponseList.add(new AuthorsResponse(authors));
        }
        return authorsResponseList;
    }

    private void addBooks(AuthorRequest authorRequest,Authors authors){
        if (!authorRequest.getBooks_id().isEmpty()){
            List<Books> books = new ArrayList<>();
            for (Long id : authorRequest.getBooks_id()) {
                books.add(booksRepository.findOne(id));
                booksRepository.findOne(id).getAuthors().add(authors);
            }
            authors.setBooks(books);
        }
    }

}