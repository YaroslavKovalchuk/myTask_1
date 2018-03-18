package com.yaroslavkovalchuk.tasksombra.service.impl;

import com.yaroslavkovalchuk.tasksombra.dto.request.BooksRequest;
import com.yaroslavkovalchuk.tasksombra.dto.response.BooksResponse;
import com.yaroslavkovalchuk.tasksombra.entity.Authors;
import com.yaroslavkovalchuk.tasksombra.entity.Books;
import com.yaroslavkovalchuk.tasksombra.repository.AuthorsRepository;
import com.yaroslavkovalchuk.tasksombra.repository.BooksRepository;
import com.yaroslavkovalchuk.tasksombra.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorsRepository authorsRepository;

    @Override
    public BooksResponse save(BooksRequest booksRequest) {

        Books books = new Books();

        books.setName(booksRequest.getName());
        books.setGenre(booksRequest.getGenre());
        books.setPublished(booksRequest.getPublished());
        books.setRating(booksRequest.getRating());
        addAuthors(booksRequest,books);

        return new BooksResponse(booksRepository.save(books));
    }


    @Override
    public BooksResponse update(Long id, BooksRequest booksRequest) {

        Books book = booksRepository.findOne(id);

        if(booksRequest.getName() != null){ book.setName(booksRequest.getName()); }
        if(booksRequest.getGenre() != null){ book.setGenre(booksRequest.getGenre()); }
        if(booksRequest.getPublished() != null){ book.setPublished(booksRequest.getPublished()); }
        if(booksRequest.getRating() != 0){ book.setRating(booksRequest.getRating()); }
        addAuthors(booksRequest,book);

        return new BooksResponse(booksRepository.save(book));
    }

    @Override
    public void delete(Long id) {
        booksRepository.delete(id);
    }

    @Override
    public List<BooksResponse> getAll() {
        List<Books> books = booksRepository.findAll();
        List<BooksResponse> booksResponses = new ArrayList<>();
        for(Books book:books){
            booksResponses.add(new BooksResponse(book));
        }
        return booksResponses;
    }

    @Override
    public BooksResponse getOne(Long id) {
        return new BooksResponse(booksRepository.findOne(id));
    }

    @Override
    public Long countBooksByGenre(String genre) {
        return booksRepository.countBooksByGenre(genre);
    }

    @Override
    public List<BooksResponse> authorHasBooks() {
        List<Books> booksList = booksRepository.booksAuthorHasBooks();
        List<BooksResponse> booksResponseList = new ArrayList<>();
        for (Books books:booksList){
            booksResponseList.add(new BooksResponse(books));
        }
        return booksResponseList;
    }


    private void addAuthors(BooksRequest booksRequest,Books books){
        if (!booksRequest.getAuthors_id().isEmpty()) {
            List<Authors> authors = new ArrayList<>();
            for (Long id : booksRequest.getAuthors_id()) {
                authors.add(authorsRepository.findOne(id));
                authorsRepository.findOne(id).getBooks().add(books);
            }
            books.setAuthors(authors);
        }
    }

}

