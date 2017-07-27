package com.indibu.indiBuserver.service;


import com.indibu.indiBuserver.core.MessageUtil;
import com.indibu.indiBuserver.data.entity.Deal;
import com.indibu.indiBuserver.data.entity.User;
import com.indibu.indiBuserver.data.repository.DealRepository;
import com.indibu.indiBuserver.data.repository.UserRepository;
import com.indibu.indiBuserver.model.BaseResponse;
import com.indibu.indiBuserver.model.DealCreateRequest;
import com.indibu.indiBuserver.model.DealCreateResponse;
import com.indibu.indiBuserver.model.DealInformation;
import com.indibu.indiBuserver.model.IndibuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DealRepository dealRepository;

    @Override
    public DealCreateResponse createDeal(DealCreateRequest dealCreateRequest, long userId) {
        Deal newDeal = new Deal(userId);

        newDeal.setDescription(dealCreateRequest.getDescription());
        newDeal.setTitle(dealCreateRequest.getTitle());
        newDeal.setCategories(dealCreateRequest.getCategories());
        newDeal.setPhotoUrl("no-photo");

        Deal savedDeal = dealRepository.save(newDeal);

        Logger.getLogger(this.getClass().getName()).info("Deal Creation Successful. " +
                "Deal Id: " + savedDeal.getId() + " User Id: " + userId);
        return new DealCreateResponse(savedDeal.getId());
    }

    @Override
    public BaseResponse terminateDeal(long dealId, long userId) {
        long deletedCount = dealRepository.deleteByIdAndUserId(dealId, userId);
        if (deletedCount == 0) {
            throw new IndibuException("No such user-deal pair", HttpStatus.BAD_REQUEST);
        }

        Logger.getLogger(this.getClass().getName()).info("Deal Termination Successful. " +
                "Deal Id: " + dealId + " User Id: " + userId);
        return new BaseResponse("deleted " + deletedCount);
    }

    @Override
    public DealInformation getDetails(long dealId) {
        return new DealInformation(dealRepository.findOne(dealId));
    }

    @Override
    public Page<DealInformation> getFeedPageable(long userId, Pageable pageable) {
        User user = userRepository.findById(userId);
        Page<Deal> dealPage = dealRepository.readAllByCategories(user.getInterestSet(), pageable);
        List<DealInformation> dealInformationList = new ArrayList<>();
        for (Deal deal : dealPage) {
            dealInformationList.add(new DealInformation(deal));
        }

        Logger.getLogger(this.getClass().getName()).info("Get Deal Feed Successful.");
        return new PageImpl<DealInformation>(dealInformationList);
    }
}
