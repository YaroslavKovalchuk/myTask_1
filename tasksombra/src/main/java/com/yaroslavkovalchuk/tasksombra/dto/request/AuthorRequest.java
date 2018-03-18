package com.yaroslavkovalchuk.tasksombra.dto.request;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AuthorRequest {

    private String name;

    private String gender;

    private Date born;

    private List<Long> books_id = new ArrayList<>();

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

    public List<Long> getBooks_id() {
        return books_id;
    }

    public void setBooks_id(List<Long> books_id) {
        books_id = books_id;
    }
}
