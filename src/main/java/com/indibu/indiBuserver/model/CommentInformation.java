package com.indibu.indiBuserver.model;

import com.indibu.indiBuserver.data.entity.Comment;

import java.util.Date;

public class CommentInformation {
    private long dealId;
    private String body;
    private String writerPhoto;
    private String writerNickname;
    private Date dateOfCreation;

    public CommentInformation() {
    }

    public CommentInformation(Comment comment) {
        this.dealId = comment.getDealId();
        this.body = comment.getBody();
        this.writerPhoto = comment.getWriterPhoto();
        this.writerNickname = comment.getWriterNickname();
        this.dateOfCreation = comment.getDateOfCreation();
    }

    public long getDealId() {
        return dealId;
    }

    public void setDealId(long dealId) {
        this.dealId = dealId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getWriterPhoto() {
        return writerPhoto;
    }

    public void setWriterPhoto(String writerPhoto) {
        this.writerPhoto = writerPhoto;
    }

    public String getWriterNickname() {
        return writerNickname;
    }

    public void setWriterNickname(String writerNickname) {
        this.writerNickname = writerNickname;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
