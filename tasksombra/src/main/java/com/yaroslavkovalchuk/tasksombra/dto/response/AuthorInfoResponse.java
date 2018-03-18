package com.yaroslavkovalchuk.tasksombra.dto.response;

import com.yaroslavkovalchuk.tasksombra.entity.Authors;

import java.sql.Date;

public class AuthorInfoResponse {

    private Long id;

    private String name;

    private String gender;

    private Date born;

    public AuthorInfoResponse(Authors authors) {
        this.id = authors.getId();
        this.name = authors.getName();
        this.gender = authors.getGender();
        this.born = authors.getBorn();
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
}
