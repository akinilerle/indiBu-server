package com.indibu.indiBuserver.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.indibu.indiBuserver.model.Category;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @ElementCollection
    @CollectionTable(name = "Deal_categories", joinColumns = @JoinColumn(name = "deal_id"))
    @Enumerated(EnumType.STRING)
    private Set<Category> categories;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfCreation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfUpdate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    private int commentCount;
    private int hotVoteCounter;
    private int coldVoteCounter;
    private String photoUrl;

    public Deal() {
    }

    public Deal(long userId) {
        Date date = new Date();
        this.dateOfCreation = date;
        this.dateOfUpdate = date;
        this.hotVoteCounter = 0;
        this.coldVoteCounter = 0;
        this.commentCount = 0;

        User user = new User();
        user.setId(userId);
        this.user = user;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void incrementHotVoteCounter() {
        this.hotVoteCounter++;
    }

    public void decrementHotVoteCounter() {
        if (this.hotVoteCounter > 1) {
            this.hotVoteCounter--;
        }
    }

    public void incrementColdVoteCounter() {
        this.coldVoteCounter++;
    }

    public void decrementColdVoteCounter() {
        if (this.coldVoteCounter > 1) {
            this.coldVoteCounter--;
        }
    }

    public void incrementCommentCount() {
        this.commentCount++;
    }

    public void decrementCommentCount() {
        if (this.commentCount > 1) {
            this.commentCount--;
        }
    }
}
