package com.indibu.indiBuserver.service;

import com.indibu.indiBuserver.model.BaseResponse;
import com.indibu.indiBuserver.model.CouponCreateRequest;
import com.indibu.indiBuserver.model.CouponCreateResponse;
import com.indibu.indiBuserver.model.CouponInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CouponService {
    CouponCreateResponse createCoupon(CouponCreateRequest couponCreateRequest, long userId);

    CouponInformation getDetails(long couponId);

    BaseResponse terminateCoupon(long couponId, long userId);

    Page<CouponInformation> getFeedPageable(Pageable pageable, long userId);
}
