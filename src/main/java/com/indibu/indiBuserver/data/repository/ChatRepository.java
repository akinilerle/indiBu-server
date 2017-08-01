package com.indibu.indiBuserver.data.repository;


import com.indibu.indiBuserver.data.entity.Chat;
import com.indibu.indiBuserver.data.entity.Coupon;
import com.indibu.indiBuserver.data.entity.User;
import com.indibu.indiBuserver.model.ChatResponseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ChatRepository extends CrudRepository<Chat, Long>, PagingAndSortingRepository<Chat, Long> {

    Chat findByCouponAndBuyer(Coupon coupon, User buyer);

    Chat findById(long id);

    Chat findByCouponAndSeller(Coupon coupon, User seller);

    List<ChatResponseModel> findAllByBuyerOrSeller(User buyer, User seller);

}
