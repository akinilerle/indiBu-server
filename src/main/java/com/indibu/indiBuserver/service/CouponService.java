package com.indibu.indiBuserver.service;

import com.indibu.indiBuserver.model.CouponCreateRequest;
import com.indibu.indiBuserver.model.CouponResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CouponService {
    void createCoupon(CouponCreateRequest couponCreateRequest, long userId);

    void terminateCoupon(long couponId, long userId);

    CouponResponseModel getDetails(long couponId);

    Page<CouponResponseModel> getFeedPageable(Pageable pageable, long userId);
}
