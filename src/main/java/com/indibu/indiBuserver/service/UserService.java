package com.indibu.indiBuserver.service;


import com.indibu.indiBuserver.model.BankAccountList;
import com.indibu.indiBuserver.model.CouponList;
import com.indibu.indiBuserver.model.CouponResponseModel;
import com.indibu.indiBuserver.model.CreateReferenceRequestBody;
import com.indibu.indiBuserver.model.DealList;
import com.indibu.indiBuserver.model.DealResponseModel;
import com.indibu.indiBuserver.model.ReferenceList;
import com.indibu.indiBuserver.model.ReferenceResponseModel;
import com.indibu.indiBuserver.model.UpdateUserInfoRequestBody;
import com.indibu.indiBuserver.model.UserInfoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    void createReference(long userId, CreateReferenceRequestBody createReferenceRequestBody);

    BankAccountList getBankAccounts(long userId);

    CouponList getCoupons(long userId);

    Page<CouponResponseModel> getCoupons(long userId, Pageable pageable);

    DealList getDeals(long userId);

    Page<DealResponseModel> getDeals(long userId, Pageable pageable);

    ReferenceList getReferences(long userId);

    Page<ReferenceResponseModel> getReferences(long userId, Pageable pageable);

    Page<ReferenceResponseModel> getReferences(String nickname, Pageable pageable);

    UserInfoResponse getInfo(long id);

    UserInfoResponse getInfo(String nickname);

    void updateInfo(long userId, UpdateUserInfoRequestBody updateUserInfoBody);

}