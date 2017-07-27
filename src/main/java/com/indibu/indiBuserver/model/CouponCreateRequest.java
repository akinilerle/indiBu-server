package com.indibu.indiBuserver.model;

public class CouponCreateRequest {

    private String title;
    private String description;
    private boolean isActive;
    private boolean acceptsCashPayment;
    private boolean acceptsOnlinePayment;
    private String city;

    public CouponCreateRequest(String title, String description, boolean acceptsCashPayment,
                               boolean acceptsOnlinePayment, String city) {
        this.title = title;
        this.description = description;
        this.acceptsCashPayment = acceptsCashPayment;
        this.acceptsOnlinePayment = acceptsOnlinePayment;
        this.city = city;
    }

    public CouponCreateRequest() {

    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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

    public boolean acceptsCashPayment() {
        return acceptsCashPayment;
    }

    public void setAcceptsCashPayment(boolean acceptsCashPayment) {
        this.acceptsCashPayment = acceptsCashPayment;
    }

    public boolean acceptsOnlinePayment() {
        return acceptsOnlinePayment;
    }

    public void setAcceptsOnlinePayment(boolean acceptsOnlinePayment) {
        this.acceptsOnlinePayment = acceptsOnlinePayment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
