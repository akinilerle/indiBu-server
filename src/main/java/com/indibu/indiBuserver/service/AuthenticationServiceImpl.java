package com.indibu.indiBuserver.service;


import com.indibu.indiBuserver.data.entity.User;
import com.indibu.indiBuserver.data.repository.UserRepository;
import com.indibu.indiBuserver.model.Category;
import com.indibu.indiBuserver.model.IndibuException;
import com.indibu.indiBuserver.model.LoginRequestBody;
import com.indibu.indiBuserver.model.RegisterRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public long login(LoginRequestBody loginRequestBody) {

        User user = null;
        if (loginRequestBody.getEmail() != null && !loginRequestBody.getEmail().equals("")) {
            user = userRepository.findByEmail(loginRequestBody.getEmail());
        } else if (loginRequestBody.getNickname() != null && !loginRequestBody.getNickname().equals("")) {
            user = userRepository.findByNickname(loginRequestBody.getNickname());
        } else {
            throw new IndibuException("Hem mail adresi hem de kullanıcı adı boş olamaz", HttpStatus.BAD_REQUEST);
        }

        //TODO:HASHING
        if (user == null || !user.getPassword().equals(loginRequestBody.getPassword())) {
            throw new IndibuException("Girdiğiniz bilgiler hatalıdır.", HttpStatus.UNAUTHORIZED);
        }

        return user.getId();
    }

    @Override
    public long register(RegisterRequestBody registerRequestBody) {

        User user = createUser(registerRequestBody);

        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    private User createUser(RegisterRequestBody registerRequestBody) {
        User user = new User();
        user.setPassword(registerRequestBody.getPassword());
        user.setEmail(registerRequestBody.getEmail());
        user.setNickname(registerRequestBody.getNickname());
        user.setFirstName(registerRequestBody.getFirstName());
        user.setLastName(registerRequestBody.getLastName());
        user.setAverageRating(0);
        user.setReviewNumberCounter(0);

        Date now = new Date();
        user.setDateOfCreation(now);
        user.setDateOfUpdate(now);

        Set<Category> interestSet;
        if(registerRequestBody.getInterestSet()==null) {
            interestSet = new HashSet<>();
            if (registerRequestBody.isClothing()) {
                interestSet.add(Category.CLOTHING);
            }
            if (registerRequestBody.isCosmetics()) {
                interestSet.add(Category.COSMETICS);
            }
            if (registerRequestBody.isElectronics()) {
                interestSet.add(Category.ELECTRONICS);
            }
            if (registerRequestBody.isFood()) {
                interestSet.add(Category.FOOD);
            }
        }

        else{
            interestSet=registerRequestBody.getInterestSet();
        }

        if (interestSet.isEmpty()) {
            interestSet.add(Category.CLOTHING);
            interestSet.add(Category.COSMETICS);
            interestSet.add(Category.ELECTRONICS);
            interestSet.add(Category.FOOD);
        }
        user.setInterestSet(interestSet);

        return user;
    }

}
