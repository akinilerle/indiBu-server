package com.indibu.indiBuserver.service;

import com.indibu.indiBuserver.model.BaseResponse;
import com.indibu.indiBuserver.model.DealCreateRequest;
import com.indibu.indiBuserver.model.DealCreateResponse;
import com.indibu.indiBuserver.model.DealInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DealService {
    DealCreateResponse createDeal(DealCreateRequest dealCreateRequest, long userId);

    BaseResponse terminateDeal(long dealId, long userId);

    DealInformation getDetails(long dealId);

    Page<DealInformation> getFeedPageable(long userId, Pageable pageable);
}
