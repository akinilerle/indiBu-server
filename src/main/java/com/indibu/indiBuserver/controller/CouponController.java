package com.indibu.indiBuserver.controller;

import com.indibu.indiBuserver.core.SessionUtil;
import com.indibu.indiBuserver.model.BaseResponse;
import com.indibu.indiBuserver.model.CouponCreateRequest;
import com.indibu.indiBuserver.model.CouponCreateResponse;
import com.indibu.indiBuserver.model.CouponInformation;
import com.indibu.indiBuserver.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/coupon")
public class CouponController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private CouponService couponService;

    @Autowired
    private SessionUtil sessionUtil;

    @RequestMapping(value = "/create", method = POST)
    public CouponCreateResponse login(@RequestBody CouponCreateRequest couponCreateRequest) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        CouponCreateResponse couponCreateResponse = couponService.createCoupon(couponCreateRequest, userId);

        Logger.getLogger(this.getClass().getName()).info("Coupon Creation Successful. " +
                "Coupon Id: " + couponCreateResponse.getCouponId() + " User Id: " + userId);
        return couponCreateResponse;
    }

    @RequestMapping(value = "/terminate")
    public BaseResponse terminateCoupon(@RequestParam long couponId) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        return couponService.terminateCoupon(couponId, userId);
    }

    @RequestMapping(value = "/details")
    public CouponInformation getDetails(@RequestParam long couponId) {
        return couponService.getDetails(couponId);
    }

    @RequestMapping(value = "/feed")
    public Page<CouponInformation> getFeed(Pageable pageable) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        return couponService.getFeedPageable(pageable, userId);
    }

}
