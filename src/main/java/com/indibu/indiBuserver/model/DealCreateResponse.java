package com.indibu.indiBuserver.model;

public class DealCreateResponse {

    private long dealId;

    public DealCreateResponse(long dealId) {
        this.dealId = dealId;
    }

    public long getDealId() {
        return dealId;
    }

    public void setDealId(long dealId) {
        this.dealId = dealId;
    }
}
