package com.indibu.indiBuserver.model;

import com.indibu.indiBuserver.data.entity.Coupon;

import java.util.Date;

public class CouponInformation {
    private String title;
    private String description;
    private boolean isActive;
    private boolean acceptsCashPayment;
    private boolean acceptsOnlinePayment;
    private Date dateOfCreation;
    private Date dateOfUpdate;
    private String city;
    private int hotVoteCounter;
    private int coldVoteCounter;

    public CouponInformation(Coupon coupon) {
        this.title = coupon.getTitle();
        this.description = coupon.getDescription();
        this.isActive = coupon.isActive();
        this.acceptsCashPayment = coupon.isAcceptsCashPayment();
        this.acceptsOnlinePayment = coupon.isAcceptsOnlinePayment();
        this.dateOfCreation = coupon.getDateOfCreation();
        this.dateOfUpdate = coupon.getDateOfUpdate();
        this.city = coupon.getCity();
        this.hotVoteCounter = coupon.getHotVoteCounter();
        this.coldVoteCounter = coupon.getColdVoteCounter();
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isAcceptsCashPayment() {
        return acceptsCashPayment;
    }

    public void setAcceptsCashPayment(boolean acceptsCashPayment) {
        this.acceptsCashPayment = acceptsCashPayment;
    }

    public boolean isAcceptsOnlinePayment() {
        return acceptsOnlinePayment;
    }

    public void setAcceptsOnlinePayment(boolean acceptsOnlinePayment) {
        this.acceptsOnlinePayment = acceptsOnlinePayment;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
