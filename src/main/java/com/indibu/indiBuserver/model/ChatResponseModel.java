package com.indibu.indiBuserver.model;

import com.indibu.indiBuserver.data.entity.Chat;
import com.indibu.indiBuserver.data.entity.Message;

import java.util.Date;
import java.util.List;


public class ChatResponseModel {

    private long id;

    private String lastMessageBody;

    private long couponId;

    private String couponTitle;

    private String buyerNickname;

    private String sellerNickname;

    private String buyerPhotoUrl;

    private String sellerPhotoUrl;

    private Date dateOfCreation;

    private Date dateOfUpdate;


    public ChatResponseModel() {
    }

    public ChatResponseModel(Chat chat) {
        id = chat.getId();
        couponId = chat.getCoupon().getId();
        couponTitle = chat.getCoupon().getTitle();
        buyerNickname = chat.getBuyer().getNickName();
        sellerNickname = chat.getSeller().getNickName();
        buyerPhotoUrl = chat.getBuyer().getPhotoUrl();
        sellerPhotoUrl = chat.getSeller().getPhotoUrl();
        dateOfCreation = chat.getDateOfCreation();
        List<Message> messageList = chat.getMessageList();
        if (!messageList.isEmpty()) {
            Message message = messageList.get(messageList.size() - 1);
            lastMessageBody = message.getBody();
            dateOfUpdate = message.getDate();
        }

    }

    public long getId() {
        return id;
    }

    public String getLastMessageBody() {
        return lastMessageBody;
    }

    public void setLastMessageBody(String lastMessageBody) {
        this.lastMessageBody = lastMessageBody;
    }

    public Date getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(Date dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public String getCouponTitle() {
        return couponTitle;
    }

    public void setCouponTitle(String couponTitle) {
        this.couponTitle = couponTitle;
    }

    public String getBuyerNickname() {
        return buyerNickname;
    }

    public void setBuyerNickname(String buyerNickname) {
        this.buyerNickname = buyerNickname;
    }

    public String getSellerNickname() {
        return sellerNickname;
    }

    public void setSellerNickname(String sellerNickname) {
        this.sellerNickname = sellerNickname;
    }

    public String getBuyerPhotoUrl() {
        return buyerPhotoUrl;
    }

    public void setBuyerPhotoUrl(String buyerPhotoUrl) {
        this.buyerPhotoUrl = buyerPhotoUrl;
    }

    public String getSellerPhotoUrl() {
        return sellerPhotoUrl;
    }

    public void setSellerPhotoUrl(String sellerPhotoUrl) {
        this.sellerPhotoUrl = sellerPhotoUrl;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
