package com.indibu.indiBuserver.model;


import com.indibu.indiBuserver.data.entity.Deal;

import java.util.ArrayList;
import java.util.List;

public class DealList {

    List<DealResponseModel> dealList;

    public DealList(List<Deal> dealList) {
        this.dealList = new ArrayList<>();

        for (Deal deal : dealList) {
            this.dealList.add(new DealResponseModel(deal));
        }

    }

    public DealList() {
    }

    public List<DealResponseModel> getDealList() {
        return dealList;
    }

    public void setDealList(List<DealResponseModel> dealList) {
        this.dealList = dealList;
    }
}