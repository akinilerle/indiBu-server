package com.indibu.indiBuserver.data.repository;

import com.indibu.indiBuserver.data.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CouponRepository extends CrudRepository<Coupon, Long>, PagingAndSortingRepository<Coupon, Long> {
    long deleteByIdAndUserId(long id, long userId);

    Page<Coupon> readAllBy(Pageable pageable);
}
