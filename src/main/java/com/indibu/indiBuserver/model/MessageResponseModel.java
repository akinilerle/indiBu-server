package com.indibu.indiBuserver.model;


import com.indibu.indiBuserver.data.entity.Message;

import java.util.Date;

public class MessageResponseModel {

    private Date date;
    private String recieverNickname;
    private long couponId;
    private String body;

    public MessageResponseModel() {
    }

    public MessageResponseModel(Message message) {
        this.body = message.getBody();
        this.recieverNickname = message.getRecieverNickname();
        this.date = message.getDate();
        this.couponId = message.getCoupon().getId();
    }

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRecieverNickname() {
        return recieverNickname;
    }

    public void setRecieverNickname(String recieverNickname) {
        this.recieverNickname = recieverNickname;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
