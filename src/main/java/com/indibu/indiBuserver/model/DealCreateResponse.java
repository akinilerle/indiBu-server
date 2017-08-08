package com.indibu.indiBuserver.model;

import com.indibu.indiBuserver.data.entity.Deal;

public class DealCreateResponse {
    private long dealId;

    public DealCreateResponse() {
    }

    public DealCreateResponse(Deal deal) {
        this.dealId = deal.getId();
    }

    public long getDealId() {
        return dealId;
    }

    public void setDealId(long dealId) {
        this.dealId = dealId;
    }
}
