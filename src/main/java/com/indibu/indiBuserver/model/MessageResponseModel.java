package com.indibu.indiBuserver.model;


import com.indibu.indiBuserver.data.entity.Message;

import java.util.Date;

public class MessageResponseModel {

    private Date date;
    private String receiverNickname;
    private String senderNickname;
    private long couponId;
    private String body;

    public MessageResponseModel() {
    }

    public MessageResponseModel(Message message) {
        this.body = message.getBody();
        this.receiverNickname = message.getReceiverNickname();
        this.senderNickname = message.getSenderNickname();
        this.date = message.getDate();
        this.couponId = message.getCoupon().getId();
    }

    public String getSenderNickname() {
        return senderNickname;
    }

    public void setSenderNickname(String senderNickname) {
        this.senderNickname = senderNickname;
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

    public String getReceiverNickname() {
        return receiverNickname;
    }

    public void setReceiverNickname(String receiverNickname) {
        this.receiverNickname = receiverNickname;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
