package com.yaroslavkovalchuk.tasksombra.dto.response;

import com.yaroslavkovalchuk.tasksombra.entity.Authors;
import com.yaroslavkovalchuk.tasksombra.entity.Books;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BooksResponse {

    private Long id;

    private String name;

    private Date published;

    private String genre;

    private int rating;

    private List<AuthorInfoResponse> authorsResponses  = new ArrayList<>();

    public BooksResponse(Books books) {
        this.id = books.getId();
        this.name = books.getName();
        this.published = books.getPublished();
        this.genre = books.getGenre();
        this.rating = books.getRating();

        if (!books.getAuthors().isEmpty()) {

            for (Authors authors : books.getAuthors()) {
                this.authorsResponses.add(new AuthorInfoResponse(authors));
            }
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<AuthorInfoResponse> getAuthorsResponses() {
        return authorsResponses;
    }

    public void setAuthorsResponses(List<AuthorInfoResponse> authorsResponses) {
        this.authorsResponses = authorsResponses;
    }
}
