package com.indibu.indiBuserver.model;


public class SendMessageRequestBody {

    private long couponId;
    private String recieverNickname;
    private String body;

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
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
