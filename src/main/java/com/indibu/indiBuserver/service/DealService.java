package com.indibu.indiBuserver.service;

import com.indibu.indiBuserver.model.CommentInformation;
import com.indibu.indiBuserver.model.DealCommentCreateRequest;
import com.indibu.indiBuserver.model.DealCreateRequest;
import com.indibu.indiBuserver.model.DealCreateResponse;
import com.indibu.indiBuserver.model.DealResponseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DealService {
    DealCreateResponse createDeal(DealCreateRequest dealCreateRequest, long userId);

    void terminateDeal(long dealId, long userId);

    DealResponseModel getDetails(long dealId);

    Page<DealResponseModel> getFeedPageable(long userId, Pageable pageable);

    void createComment(long userId, DealCommentCreateRequest dealCommentCreateRequest);

    Page<CommentInformation> getComments(long dealId, Pageable pageable);

}
