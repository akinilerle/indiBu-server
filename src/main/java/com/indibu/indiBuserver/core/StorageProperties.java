package com.indibu.indiBuserver.core;

import org.springframework.stereotype.Service;

@Service
public class StorageProperties {

    private String userPhotoLocation = "src/main/resources/upload-dir/userPhotos";

    private String dealPhotoLocation = "src/main/resources/upload-dir/dealPhotos";

    public String getUserPhotoLocation() {
        return userPhotoLocation;
    }

    public void setUserPhotoLocation(String userPhotoLocation) {
        this.userPhotoLocation = userPhotoLocation;
    }

    public String getDealPhotoLocation() {
        return dealPhotoLocation;
    }

    public void setDealPhotoLocation(String dealPhotoLocation) {
        this.dealPhotoLocation = dealPhotoLocation;
    }
}