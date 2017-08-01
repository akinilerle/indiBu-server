package com.indibu.indiBuserver.model;

import com.indibu.indiBuserver.data.entity.Reference;

import java.util.Date;

public class ReferenceResponseModel {

    private long id;

    private String writerPhotoUrl;

    private String writerNickname;

    private String comment;

    private int rating;

    private Date dateOfCreation;

    public ReferenceResponseModel() {
    }

    public ReferenceResponseModel(Reference reference) {

        id = reference.getId();
        writerPhotoUrl = reference.getWriterPhotoUrl();
        writerNickname = reference.getWriterNickname();
        comment = reference.getComment();
        rating = reference.getRating().ordinal();
        dateOfCreation = reference.getDateOfCreation();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWriterPhotoUrl() {
        return writerPhotoUrl;
    }

    public void setWriterPhotoUrl(String writerPhotoUrl) {
        this.writerPhotoUrl = writerPhotoUrl;
    }

    public String getWriterNickname() {
        return writerNickname;
    }

    public void setWriterNickname(String writerNickname) {
        this.writerNickname = writerNickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
