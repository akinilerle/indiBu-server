package com.indibu.indiBuserver.model;


import com.indibu.indiBuserver.data.entity.Deal;

import java.util.Date;
import java.util.Set;

public class DealResponseModel {

    private long id;
    private String title;
    private String description;
    private Set<Category> categories;
    private Date dateOfCreation;
    private Date dateOfUpdate;
    private int hotVoteCounter;
    private int coldVoteCounter;
    private String author;
    private double referencePoint;
    private int referenceCount;
    private int commentCount;
    private double locationX;
    private double locationY;
    boolean isHotVoted;
    boolean isColdVoted;

    public DealResponseModel() {
    }

    public DealResponseModel(Deal deal) {

        id = deal.getId();
        title = deal.getTitle();
        description = deal.getDescription();
        categories = deal.getCategories();
        dateOfCreation = deal.getDateOfCreation();
        dateOfUpdate = deal.getDateOfUpdate();
        hotVoteCounter = deal.getHotVoteCounter();
        coldVoteCounter = deal.getColdVoteCounter();
        commentCount = deal.getCommentCount();
        locationX = deal.getLocationX();
        locationY = deal.getLocationY();

        author = deal.getUser().getNickname();
        referencePoint = deal.getUser().getAverageRating();
        referenceCount = deal.getUser().getReviewNumberCounter();

    }

    public boolean isHotVoted() {
        return isHotVoted;
    }

    public void setHotVoted(boolean hotVoted) {
        isHotVoted = hotVoted;
    }

    public boolean isColdVoted() {
        return isColdVoted;
    }

    public void setColdVoted(boolean coldVoted) {
        isColdVoted = coldVoted;
    }

    public double getLocationX() {
        return locationX;
    }

    public void setLocationX(double locationX) {
        this.locationX = locationX;
    }

    public double getLocationY() {
        return locationY;
    }

    public void setLocationY(double locationY) {
        this.locationY = locationY;
    }

    public int getReferenceCount() {
        return referenceCount;
    }

    public void setReferenceCount(int referenceCount) {
        this.referenceCount = referenceCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(double referencePoint) {
        this.referencePoint = referencePoint;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Date getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(Date dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public int getHotVoteCounter() {
        return hotVoteCounter;
    }

    public void setHotVoteCounter(int hotVoteCounter) {
        this.hotVoteCounter = hotVoteCounter;
    }

    public int getColdVoteCounter() {
        return coldVoteCounter;
    }

    public void setColdVoteCounter(int coldVoteCounter) {
        this.coldVoteCounter = coldVoteCounter;
    }

}
