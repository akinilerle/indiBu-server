package com.indibu.indiBuserver.controller;

import com.indibu.indiBuserver.core.SessionUtil;
import com.indibu.indiBuserver.model.CouponCreateRequest;
import com.indibu.indiBuserver.model.CouponResponseModel;
import com.indibu.indiBuserver.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
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
    public void createCoupon(@RequestBody CouponCreateRequest couponCreateRequest) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        couponService.createCoupon(couponCreateRequest, userId);
    }

    @RequestMapping(value = "/terminate", method = DELETE)
    public void terminateCoupon(@RequestParam long couponId) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        couponService.terminateCoupon(couponId, userId);
    }

    @RequestMapping(value = "/details", method = GET)
    public CouponResponseModel getDetails(@RequestParam long couponId) {
        return couponService.getDetails(couponId);
    }

    @RequestMapping(value = "/feed", method = GET)
    public Page<CouponResponseModel> getFeed(Pageable pageable) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        return couponService.getFeedPageable(pageable, userId);
    }

}
