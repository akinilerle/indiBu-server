package com.indibu.indiBuserver.data.repository;

import com.indibu.indiBuserver.data.entity.Coupon;
import com.indibu.indiBuserver.data.entity.User;
import com.indibu.indiBuserver.model.CouponResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CouponRepository extends CrudRepository<Coupon, Long>, PagingAndSortingRepository<Coupon, Long> {

    Page<CouponResponseModel> readAllByUser(User user, Pageable pageable);

    Coupon findById(long id);

    long deleteByIdAndUserId(long id, long userId);

    Page<Coupon> readAllByUserNotLike(User user, Pageable pageable);


}
