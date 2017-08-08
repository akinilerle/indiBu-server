package com.indibu.indiBuserver.controller;

import com.indibu.indiBuserver.core.SessionUtil;
import com.indibu.indiBuserver.model.BankAccountList;
import com.indibu.indiBuserver.model.CouponResponseModel;
import com.indibu.indiBuserver.model.CreateReferenceRequestBody;
import com.indibu.indiBuserver.model.DealResponseModel;
import com.indibu.indiBuserver.model.ReferenceResponseModel;
import com.indibu.indiBuserver.model.UpdateUserInfoRequestBody;
import com.indibu.indiBuserver.model.UserInfoResponse;
import com.indibu.indiBuserver.model.UserVoteDealRequest;
import com.indibu.indiBuserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private SessionUtil sessionUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;


    @RequestMapping(value = "/reference", method = POST)
    void createReference(@RequestBody CreateReferenceRequestBody createReferenceRequestBody) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        userService.createReference(userId, createReferenceRequestBody);
    }

    /**
     * updates user information.
     *
     * @param updateUserInfoBody: updates the info only if they are not null, except for the interest parameters, they are updated
     *                            on every request. So they must be consistent.
     */
    @RequestMapping(value = "/info", method = RequestMethod.PUT)
    void updateInfo(@RequestBody UpdateUserInfoRequestBody updateUserInfoBody) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        userService.updateInfo(userId, updateUserInfoBody);

    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public UserInfoResponse getInfo(String nickname) {
        if (nickname == null) {
            long userId = sessionUtil.getUserId(httpServletRequest);
            return userService.getInfo(userId);
        }

        return userService.getInfo(nickname);

    }


    @RequestMapping(value = "/references", method = RequestMethod.GET)
    public Page<ReferenceResponseModel> getReferences(Pageable pageable, String nickname) {
        if (nickname == null) {
            long userId = sessionUtil.getUserId(httpServletRequest);
            return userService.getReferences(userId, pageable);
        }
        return userService.getReferences(nickname, pageable);
    }


    @RequestMapping(value = "/deals", method = RequestMethod.GET)
    public Page<DealResponseModel> getDeals(Pageable pageable) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        return userService.getDeals(userId, pageable);
    }


    @RequestMapping(value = "/coupons", method = RequestMethod.GET)
    public Page<CouponResponseModel> getCoupons(Pageable pageable) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        return userService.getCoupons(userId, pageable);
    }

    @RequestMapping(value = "/bankaccounts", method = RequestMethod.GET)
    public BankAccountList getBankAccounts() {
        long userId = sessionUtil.getUserId(httpServletRequest);
        return userService.getBankAccounts(userId);
    }

    @RequestMapping(value = "/vote", method = POST)
    public void vote(@RequestBody UserVoteDealRequest userVoteDealRequest) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        userService.vote(userId, userVoteDealRequest);
    }

}
