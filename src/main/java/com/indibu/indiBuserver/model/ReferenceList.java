package com.indibu.indiBuserver.model;


import com.indibu.indiBuserver.data.entity.Reference;

import java.util.ArrayList;
import java.util.List;

public class ReferenceList {

    List<ReferenceResponseModel> referenceList;


    public ReferenceList(List<Reference> referenceList) {
        this.referenceList = new ArrayList<>();
        for (Reference reference : referenceList) {
            this.referenceList.add(new ReferenceResponseModel(reference));
        }
    }


    public ReferenceList() {
    }

    public List<ReferenceResponseModel> getReferenceList() {
        return referenceList;
    }

    public void setReferenceList(List<ReferenceResponseModel> referenceList) {
        this.referenceList = referenceList;
    }
}
