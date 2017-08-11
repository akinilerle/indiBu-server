package com.indibu.indiBuserver.data.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.indibu.indiBuserver.model.SendMessageRequestBody;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    @JsonIgnore
    private Coupon coupon;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String receiverNickname;
    private String senderNickname;
    private String body;


    public Message() {
    }

    public Message(SendMessageRequestBody messageRequestBody, Coupon coupon, User user) {

        this.coupon = coupon;
        this.date = new Date();
        this.receiverNickname = messageRequestBody.getReceiverNickname();
        this.senderNickname = user.getNickname();
        this.body = messageRequestBody.getBody();

    }

    @Override
    public boolean equals(Object other) {
        Message otherM = null;
        try {
            otherM = (Message) other;
        } catch (Exception e) {
            return false;
        }

        if (!otherM.date.equals(date) && otherM.body.equals(body)) {
            return true;
        }

        return false;

    }

    public String getSenderNickname() {
        return senderNickname;
    }

    public void setSenderNickname(String senderNickname) {
        this.senderNickname = senderNickname;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public long getId() {
        return id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(long id) {
        this.id = id;
    }
}
