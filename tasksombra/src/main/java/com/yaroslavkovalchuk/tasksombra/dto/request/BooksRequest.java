package com.yaroslavkovalchuk.tasksombra.dto.request;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BooksRequest {

    private String name;

    private Date published;

    private String genre;

    private int rating;

    private List<Long> authors_id = new ArrayList<>();

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

    public List<Long> getAuthors_id() {
        return authors_id;
    }

    public void setAuthors_id(List<Long> authors_id) {
        this.authors_id = authors_id;
    }
}
