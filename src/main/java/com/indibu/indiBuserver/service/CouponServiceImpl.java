package com.indibu.indiBuserver.service;

import com.indibu.indiBuserver.core.MessageUtil;
import com.indibu.indiBuserver.data.entity.Coupon;
import com.indibu.indiBuserver.data.repository.CouponRepository;
import com.indibu.indiBuserver.model.BaseResponse;
import com.indibu.indiBuserver.model.CouponCreateRequest;
import com.indibu.indiBuserver.model.CouponCreateResponse;
import com.indibu.indiBuserver.model.CouponInformation;
import com.indibu.indiBuserver.model.IndibuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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


    @Override
    public CouponCreateResponse createCoupon(CouponCreateRequest couponCreateRequest, long userId) {
        Coupon newCoupon = new Coupon(userId);

        newCoupon.setAcceptsCashPayment(couponCreateRequest.acceptsCashPayment());
        newCoupon.setAcceptsOnlinePayment(couponCreateRequest.acceptsOnlinePayment());
        newCoupon.setDescription(couponCreateRequest.getDescription());
        newCoupon.setTitle(couponCreateRequest.getTitle());
        newCoupon.setCity(couponCreateRequest.getCity());

        Coupon savedCoupon = couponRepository.save(newCoupon);

        return new CouponCreateResponse(savedCoupon.getId());
    }

    @Override
    public CouponInformation getDetails(long couponId) {
        Coupon coupon = couponRepository.findOne(couponId);
        return new CouponInformation(coupon);
    }

    @Transactional
    @Override
    public BaseResponse terminateCoupon(long couponId, long userId) {
        long deletedCount = couponRepository.deleteByIdAndUserId(couponId, userId);
        if (deletedCount == 0) {
            throw new IndibuException("No such user-coupon pair", HttpStatus.BAD_REQUEST);
        }

        Logger.getLogger(this.getClass().getName()).info("Coupon Termination Successful. " +
                "Coupon Id: " + couponId + " User Id: " + userId);
        return new BaseResponse("deleted " + deletedCount);
    }

    @Override
    public Page<CouponInformation> getFeedPageable(Pageable pageable) {
        Page<Coupon> couponPage = couponRepository.readAllBy(pageable);
        List<CouponInformation> couponInformationList = new ArrayList<>();
        for (Coupon coupon : couponPage) {
            couponInformationList.add(new CouponInformation(coupon));
        }

        Logger.getLogger(this.getClass().getName()).info("Get Coupon Feed Successful.");
        return new PageImpl<CouponInformation>(couponInformationList);
    }


}
