package com.indibu.indiBuserver.model;

public class CouponCreateResponse {
    private long couponId;

    public CouponCreateResponse(long couponId) {
        this.couponId = couponId;
    }

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }
}
