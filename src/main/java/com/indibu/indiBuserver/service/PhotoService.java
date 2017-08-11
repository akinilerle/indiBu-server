package com.indibu.indiBuserver.service;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface PhotoService {

    void uploadUserPhoto(MultipartFile multipartFile, long userId);

    void uploadDealPhoto(MultipartFile multipartFile, long userId, long dealId);

    Resource loadAsResource(String filename, boolean isUser);

    Path load(String filename, boolean isUser);
}
