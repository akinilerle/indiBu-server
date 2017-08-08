package com.indibu.indiBuserver.controller;

import com.indibu.indiBuserver.core.SessionUtil;
import com.indibu.indiBuserver.model.CommentInformation;
import com.indibu.indiBuserver.model.DealCommentCreateRequest;
import com.indibu.indiBuserver.model.DealCreateRequest;
import com.indibu.indiBuserver.model.DealCreateResponse;
import com.indibu.indiBuserver.model.DealResponseModel;
import com.indibu.indiBuserver.service.DealService;
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
@RequestMapping(value = "/deal")
public class DealController {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private DealService dealService;

    @Autowired
    private SessionUtil sessionUtil;

    @RequestMapping(value = "/create", method = POST)
    public DealCreateResponse createDeal(@RequestBody DealCreateRequest dealCreateRequest) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        return dealService.createDeal(dealCreateRequest, userId);
    }

    @RequestMapping(value = "/terminate", method = DELETE)
    public void terminateDeal(@RequestParam long dealId) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        dealService.terminateDeal(dealId, userId);
    }

    @RequestMapping(value = "/details", method = GET)
    public DealResponseModel getDetails(@RequestParam long dealId) {
        return dealService.getDetails(dealId);
    }

    @RequestMapping(value = "/feed", method = GET)
    public Page<DealResponseModel> getFeed(Pageable pageable) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        return dealService.getFeedPageable(userId, pageable);
    }

    @RequestMapping(value = "/comment", method = POST)
    public void addComment(@RequestBody DealCommentCreateRequest dealCommentCreateRequest) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        dealService.createComment(userId, dealCommentCreateRequest);
    }

    @RequestMapping(value = "/comment", method = GET)
    public Page<CommentInformation> getComments(@RequestParam long dealId, Pageable pageable) {
        return dealService.getComments(dealId, pageable);
    }

}
