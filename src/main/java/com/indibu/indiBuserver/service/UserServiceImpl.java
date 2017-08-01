package com.indibu.indiBuserver.service;

import com.indibu.indiBuserver.core.CheckerUtill;
import com.indibu.indiBuserver.data.entity.Reference;
import com.indibu.indiBuserver.data.entity.User;
import com.indibu.indiBuserver.data.repository.CouponRepository;
import com.indibu.indiBuserver.data.repository.DealRepository;
import com.indibu.indiBuserver.data.repository.ReferenceRepository;
import com.indibu.indiBuserver.data.repository.UserRepository;
import com.indibu.indiBuserver.model.BankAccountList;
import com.indibu.indiBuserver.model.Category;
import com.indibu.indiBuserver.model.CouponList;
import com.indibu.indiBuserver.model.CouponResponseModel;
import com.indibu.indiBuserver.model.CreateReferenceRequestBody;
import com.indibu.indiBuserver.model.DealList;
import com.indibu.indiBuserver.model.DealResponseModel;
import com.indibu.indiBuserver.model.IndibuException;
import com.indibu.indiBuserver.model.ReferenceList;
import com.indibu.indiBuserver.model.ReferenceResponseModel;
import com.indibu.indiBuserver.model.UpdateUserInfoRequestBody;
import com.indibu.indiBuserver.model.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private ReferenceRepository referenceRepository;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private CheckerUtill checkerUtill;

    @Override
    public void createReference(long userId, CreateReferenceRequestBody requestBody) {
        User writer = userRepository.findById(userId);
        checkerUtill.userCheck(writer);

        User reciever = userRepository.findByNickname(requestBody.getNickname());
        if (reciever == null) {
            throw new IndibuException("Kullanıcı adı bulunamadı.", HttpStatus.NOT_FOUND);
        }

        if (writer.equals(reciever)) {
            throw new IndibuException("Kullanıcılar kendine referans yazamaz.", HttpStatus.FORBIDDEN);
        }

        Reference reference = new Reference();
        reference.setComment(requestBody.getComment());
        reference.setDateOfCreation(new Date());
        reference.setRating(requestBody.getStarRating());
        reference.setWriterNickname(writer.getNickname());
        reference.setUser(reciever);
        reference.setWriterPhotoUrl(reciever.getPhotoUrl());

        reciever.addReference(reference);

        referenceRepository.save(reference);
        userRepository.save(reciever);

    }

    @Override
    public BankAccountList getBankAccounts(long userId) {
        User user = userRepository.findById(userId);
        checkerUtill.userCheck(user);

        return new BankAccountList(user.getBankAccountList());
    }

    @Override
    public CouponList getCoupons(long userId) {

        User user = userRepository.findById(userId);
        checkerUtill.userCheck(user);

        return new CouponList(user.getCouponList());
    }

    @Override
    public Page<CouponResponseModel> getCoupons(long userId, Pageable pageable) {

        User user = userRepository.findById(userId);
        checkerUtill.userCheck(user);
        return couponRepository.readAllByUser(user, pageable);

    }


    @Override
    public DealList getDeals(long userId) {

        User user = userRepository.findById(userId);
        checkerUtill.userCheck(user);

        return new DealList(user.getDealList());
    }

    public Page<DealResponseModel> getDeals(long userId, Pageable pageable) {

        User user = userRepository.findById(userId);
        checkerUtill.userCheck(user);
        return dealRepository.readAllByUser(user, pageable);
    }


    @Override
    public ReferenceList getReferences(long userId) {
        User user = userRepository.findById(userId);
        checkerUtill.userCheck(user);

        return new ReferenceList(user.getReferenceList());
    }

    @Override
    public Page<ReferenceResponseModel> getReferences(long userId, Pageable pageable) {
        User user = userRepository.findById(userId);
        checkerUtill.userCheck(user);
        return referenceRepository.readAllByUser(user, pageable);
    }

    @Override
    public Page<ReferenceResponseModel> getReferences(String nickname, Pageable pageable) {
        User user = userRepository.findByNickname(nickname);
        checkerUtill.userCheck(user);
        return referenceRepository.readAllByUser(user, pageable);
    }

    @Override
    public UserInfoResponse getInfo(long id) {
        User user = userRepository.findById(id);
        checkerUtill.userCheck(user);

        return new UserInfoResponse(user);
    }

    @Override
    public UserInfoResponse getInfo(String nickname) {

        User user = userRepository.findByNickname(nickname);
        checkerUtill.userCheck(user);

        return UserInfoResponse.userInfoFactory(user);
    }

    @Override
    public void updateInfo(long userId, UpdateUserInfoRequestBody updateUserInfoBody) {

        User user = userRepository.findById(userId);
        checkerUtill.userCheck(user);

        if (updateUserInfoBody.getFirstName() != null && !updateUserInfoBody.getFirstName().equals("")) {
            user.setFirstName(updateUserInfoBody.getFirstName());
        }

        if (updateUserInfoBody.getLastName() != null && !updateUserInfoBody.getLastName().equals("")) {
            user.setLastName(updateUserInfoBody.getLastName());
        }

        if (updateUserInfoBody.getNewPassword() != null && updateUserInfoBody.getOldPassword() != null &&
                !updateUserInfoBody.getNewPassword().equals("") && !updateUserInfoBody.getOldPassword().equals("")) {

            if (user.getPassword().equals(updateUserInfoBody.getOldPassword())) {
                user.setPassword(updateUserInfoBody.getNewPassword());
            } else {
                throw new IndibuException("Hatalı eski şifre", HttpStatus.BAD_REQUEST);
            }

        }

        Set<Category> interestSet = new HashSet<>();

        if (updateUserInfoBody.isElectronics()) {
            interestSet.add(Category.ELECTRONICS);
        }
        if (updateUserInfoBody.isClothing()) {
            interestSet.add(Category.CLOTHING);
        }
        if (updateUserInfoBody.isFood()) {
            interestSet.add(Category.FOOD);
        }
        if (updateUserInfoBody.isCosmetics()) {
            interestSet.add(Category.COSMETICS);
        }

        user.setInterestSet(interestSet);

        userRepository.save(user);

    }

}
