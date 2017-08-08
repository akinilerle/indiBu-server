package com.indibu.indiBuserver.model;

public class CouponCreateRequest {

    private String title;
    private String description;
    private boolean acceptsCashPayment;
    private boolean acceptsOnlinePayment;
    private String city;
    private double price;

    public CouponCreateRequest(String title, String description, boolean acceptsCashPayment,
                               boolean acceptsOnlinePayment, String city, double price) {
        this.title = title;
        this.description = description;
        this.acceptsCashPayment = acceptsCashPayment;
        this.acceptsOnlinePayment = acceptsOnlinePayment;
        this.city = city;
        this.price = price;
    }

    public CouponCreateRequest() {

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
