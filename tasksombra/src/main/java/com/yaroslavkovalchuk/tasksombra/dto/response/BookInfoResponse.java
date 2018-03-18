package com.yaroslavkovalchuk.tasksombra.dto.response;

import com.yaroslavkovalchuk.tasksombra.entity.Books;

import java.sql.Date;

public class BookInfoResponse {

    private Long id;

    private String name;

    private Date published;

    private String genre;

    private int rating;

    public BookInfoResponse(Books books) {
        this.id = books.getId();
        this.name = books.getName();
        this.published = books.getPublished();
        this.genre = books.getGenre();
        this.rating = books.getRating();
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
}
