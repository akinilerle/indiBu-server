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
import java.util.Objects;

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

    private String recieverNickname;
    private String body;


    public Message() {
    }

    public Message(SendMessageRequestBody messageRequestBody, Coupon coupon) {

        this.coupon = coupon;
        this.date = new Date();
        this.recieverNickname = messageRequestBody.getRecieverNickname();
        this.body = messageRequestBody.getBody();

    }

    @Override
    public boolean equals(Object other) {
        Message otherM = null;
        if (!(other instanceof Message)) {
            return false;
        }
        otherM = (Message) other;
        if (otherM.date.equals(date) && otherM.body.equals(body)) {
            return true;
        }

        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(date, body);
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
