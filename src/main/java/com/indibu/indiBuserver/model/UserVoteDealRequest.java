package com.indibu.indiBuserver.model;

public class UserVoteDealRequest {
    private long dealId;
    private boolean isHot;

    public UserVoteDealRequest() {

    }

    public long getDealId() {
        return dealId;
    }

    public void setDealId(long dealId) {
        this.dealId = dealId;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

}
