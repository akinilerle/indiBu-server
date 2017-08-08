package com.indibu.indiBuserver.model;

public class DealCommentCreateRequest {
    private long dealId;
    private String body;

    public DealCommentCreateRequest() {
    }

    public long getDealId() {
        return dealId;
    }

    public void setDealId(long dealId) {
        this.dealId = dealId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
