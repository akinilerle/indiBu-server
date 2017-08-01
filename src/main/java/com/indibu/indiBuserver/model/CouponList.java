package com.indibu.indiBuserver.model;


import com.indibu.indiBuserver.data.entity.Coupon;

import java.util.ArrayList;
import java.util.List;

public class CouponList {

    List<CouponResponseModel> couponList;

    public CouponList(List<Coupon> couponList) {
        this.couponList = new ArrayList<>();
        for (Coupon coupon : couponList) {
            this.couponList.add(new CouponResponseModel(coupon));
        }
    }

    public CouponList() {
    }

    public void setCouponList(List<CouponResponseModel> couponList) {
        this.couponList = couponList;
    }

    public List<CouponResponseModel> getCouponList() {
        return couponList;
    }
}
