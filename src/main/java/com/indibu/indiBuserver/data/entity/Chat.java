package com.indibu.indiBuserver.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "chat_id")
    private List<Message> messageList;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    @JsonIgnore
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    @JsonIgnore
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    @JsonIgnore
    private User seller;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfCreation;

    public Chat() {
    }

    public Chat(Coupon coupon, User buyer) {

        this.dateOfCreation = new Date();
        this.buyer = buyer;
        this.seller = coupon.getUser();
        this.coupon = coupon;
        messageList = new ArrayList<>();

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
