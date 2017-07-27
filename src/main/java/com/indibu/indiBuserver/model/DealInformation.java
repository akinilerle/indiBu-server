package com.indibu.indiBuserver.model;

import com.indibu.indiBuserver.data.entity.Deal;
import com.indibu.indiBuserver.data.entity.User;

import java.util.Date;
import java.util.Set;

public class DealInformation {
    private String title;
    private String description;
    private Set<Category> categories;
    private Date dateOfCreation;
    private Date dateOfUpdate;
    private User user;
    private int hotVoteCounter;
    private int coldVoteCounter;
    private String photoUrl;

    public DealInformation(Deal deal) {
        this.title = deal.getTitle();
        this.description = deal.getDescription();
        this.categories = deal.getCategories();
        this.dateOfCreation = deal.getDateOfCreation();
        this.dateOfUpdate = deal.getDateOfUpdate();
        this.hotVoteCounter = deal.getHotVoteCounter();
        this.coldVoteCounter = deal.getColdVoteCounter();
        this.photoUrl = deal.getPhotoUrl();
    }

}
