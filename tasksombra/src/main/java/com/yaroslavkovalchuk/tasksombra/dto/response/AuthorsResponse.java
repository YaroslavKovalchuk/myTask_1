package com.yaroslavkovalchuk.tasksombra.dto.response;

import com.yaroslavkovalchuk.tasksombra.entity.Authors;
import com.yaroslavkovalchuk.tasksombra.entity.Books;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AuthorsResponse {

    private Long id;

    private String name;

    private String gender;

    private Date born;

    private List<BookInfoResponse> booksResponse = new ArrayList<>();

    public AuthorsResponse(Authors authors) {
        this.id = authors.getId();
        this.name = authors.getName();
        this.gender = authors.getGender();
        this.born = authors.getBorn();

        if (!authors.getBooks().isEmpty()) {

            for (Books books : authors.getBooks()) {
                this.booksResponse.add(new BookInfoResponse(books));
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public List<BookInfoResponse> getBooksResponse() {
        return booksResponse;
    }

    public void setBooksResponse(List<BookInfoResponse> booksResponse) {
        this.booksResponse = booksResponse;
    }
}
