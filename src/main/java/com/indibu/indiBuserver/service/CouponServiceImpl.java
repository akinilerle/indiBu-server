package com.indibu.indiBuserver.service;

import com.indibu.indiBuserver.core.MessageUtil;
import com.indibu.indiBuserver.data.entity.Coupon;
import com.indibu.indiBuserver.data.entity.User;
import com.indibu.indiBuserver.data.repository.CouponRepository;
import com.indibu.indiBuserver.data.repository.UserRepository;
import com.indibu.indiBuserver.model.CouponCreateRequest;
import com.indibu.indiBuserver.model.CouponResponseModel;
import com.indibu.indiBuserver.model.IndibuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void createCoupon(CouponCreateRequest couponCreateRequest, long userId) {
        Coupon newCoupon = new Coupon(userId);

        newCoupon.setAcceptsCashPayment(couponCreateRequest.acceptsCashPayment());
        newCoupon.setAcceptsOnlinePayment(couponCreateRequest.acceptsOnlinePayment());
        newCoupon.setDescription(couponCreateRequest.getDescription());
        newCoupon.setTitle(couponCreateRequest.getTitle());
        newCoupon.setCity(couponCreateRequest.getCity());
        newCoupon.setPrice(couponCreateRequest.getPrice());

        couponRepository.save(newCoupon);

    }

    @Override
    public CouponResponseModel getDetails(long couponId) {
        Coupon coupon = couponRepository.findOne(couponId);
        return new CouponResponseModel(coupon);
    }

    @Transactional
    @Override
    public void terminateCoupon(long couponId, long userId) {
        long deletedCount = couponRepository.deleteByIdAndUserId(couponId, userId);
        if (deletedCount == 0) {
            throw new IndibuException("No such user-coupon pair", HttpStatus.BAD_REQUEST);
        }

        Logger.getLogger(this.getClass().getName()).info("Coupon Termination Successful. " +
                "Coupon Id: " + couponId + " User Id: " + userId);
    }

    @Override
    public Page<CouponResponseModel> getFeedPageable(Pageable pageable, long userId) {
        User user = userRepository.findById(userId);

        Logger.getLogger(this.getClass().getName()).info("Get Coupon Feed Successful.");
        return couponRepository.readAllByUserNotLike(user, pageable);
    }


}
