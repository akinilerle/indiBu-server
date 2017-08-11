package com.indibu.indiBuserver.service;


import com.indibu.indiBuserver.core.MessageUtil;
import com.indibu.indiBuserver.core.NullClassChecker;
import com.indibu.indiBuserver.data.entity.Comment;
import com.indibu.indiBuserver.data.entity.Deal;
import com.indibu.indiBuserver.data.entity.User;
import com.indibu.indiBuserver.data.repository.CommentRepository;
import com.indibu.indiBuserver.data.repository.DealRepository;
import com.indibu.indiBuserver.data.repository.UserRepository;
import com.indibu.indiBuserver.model.CommentInformation;
import com.indibu.indiBuserver.model.DealCommentCreateRequest;
import com.indibu.indiBuserver.model.DealCreateRequest;
import com.indibu.indiBuserver.model.DealCreateResponse;
import com.indibu.indiBuserver.model.DealResponseModel;
import com.indibu.indiBuserver.model.IndibuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Logger;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private NullClassChecker nullClassChecker;

    @Override
    public DealCreateResponse createDeal(DealCreateRequest dealCreateRequest, long userId) {
        Deal newDeal = new Deal(userId);

        newDeal.setDescription(dealCreateRequest.getDescription());
        newDeal.setTitle(dealCreateRequest.getTitle());
        newDeal.setCategories(dealCreateRequest.getCategories());
        newDeal.setLocationX(dealCreateRequest.getLocationX());
        newDeal.setLocationY(dealCreateRequest.getLocationY());

        Deal deal = dealRepository.save(newDeal);
        return new DealCreateResponse(deal);
    }

    @Override
    public void terminateDeal(long dealId, long userId) {
        long deletedCount = dealRepository.deleteByIdAndUserId(dealId, userId);
        if (deletedCount == 0) {
            throw new IndibuException("No such user-deal pair", HttpStatus.BAD_REQUEST);
        }

        Logger.getLogger(this.getClass().getName()).info("Deal Termination Successful. " +
                "Deal Id: " + dealId + " User Id: " + userId);

    }

    @Override
    public DealResponseModel getDetails(long dealId) {
        return new DealResponseModel(dealRepository.findOne(dealId));
    }

    @Override
    public Page<DealResponseModel> getFeedPageable(long userId, Pageable pageable) {
        User user = userRepository.findById(userId);
        return dealRepository.readAllByCategoriesIn(user.getInterestSet(), pageable);

    }

    @Override
    public void createComment(long userId, DealCommentCreateRequest dealCommentCreateRequest) {
        User user = userRepository.findById(userId);

        Comment newComment = new Comment();
        newComment.setDateOfCreation(new Date());
        newComment.setBody(dealCommentCreateRequest.getBody());
        newComment.setDealId(dealCommentCreateRequest.getDealId());
        newComment.setWriterNickname(user.getNickname());
        commentRepository.save(newComment);

        Deal deal = dealRepository.findOne(dealCommentCreateRequest.getDealId());
        deal.incrementCommentCount();
        dealRepository.save(deal);

    }

    @Override
    public Page<CommentInformation> getComments(long dealId, Pageable pageable) {
        return commentRepository.readAllByDealId(dealId, pageable);
    }

}
