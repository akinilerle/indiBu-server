package com.indibu.indiBuserver.controller;

import com.indibu.indiBuserver.core.Constants;
import com.indibu.indiBuserver.core.SessionUtil;
import com.indibu.indiBuserver.model.BaseResponse;
import com.indibu.indiBuserver.model.DealCreateRequest;
import com.indibu.indiBuserver.model.DealCreateResponse;
import com.indibu.indiBuserver.model.DealInformation;
import com.indibu.indiBuserver.service.DealService;
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
@RequestMapping(value = "/deal")
public class DealController {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    private DealService dealService;

    @Autowired
    private SessionUtil sessionUtil;

    @RequestMapping(value = "/create", method = POST)
    public DealCreateResponse login(@RequestBody DealCreateRequest dealCreateRequest) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        DealCreateResponse dealCreateResponse = dealService.createDeal(dealCreateRequest, userId);

        Logger.getLogger(this.getClass().getName()).info("Deal Creation Successful. " +
                "Deal Id: " + dealCreateResponse.getDealId() + " User Id: " + userId);
        return dealCreateResponse;
    }


    @RequestMapping(value = "/terminate")
    public BaseResponse terminateDeal(@RequestParam(Constants.COUPON_ID) long dealId) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        return dealService.terminateDeal(dealId, userId);
    }

    @RequestMapping(value = "/details")
    public DealInformation getDetails(@RequestParam(Constants.COUPON_ID) long dealId) {
        return dealService.getDetails(dealId);
    }

    @RequestMapping(value = "/feed")
    public Page<DealInformation> getFeed(Pageable pageable) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        return dealService.getFeedPageable(userId, pageable);
    }


}
