package com.indibu.indiBuserver.service;


import com.indibu.indiBuserver.core.CheckerUtill;
import com.indibu.indiBuserver.core.StorageProperties;
import com.indibu.indiBuserver.data.entity.Deal;
import com.indibu.indiBuserver.data.entity.User;
import com.indibu.indiBuserver.data.repository.DealRepository;
import com.indibu.indiBuserver.data.repository.UserRepository;
import com.indibu.indiBuserver.model.IndibuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    public PhotoServiceImpl(StorageProperties properties) {
        this.userLocation = Paths.get(properties.getUserPhotoLocation());
        this.dealLocation = Paths.get(properties.getDealPhotoLocation());
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private CheckerUtill checkerUtill;

    private Path userLocation;

    private Path dealLocation;

    @Override
    public void uploadUserPhoto(MultipartFile file, long userId) {
        User user = userRepository.findById(userId);
        checkerUtill.userCheck(user);
        String filename = user.getNickname() + "_*_*_.png";
        try {
            if (file.isEmpty()) {
                throw new IndibuException("Failed to store empty file " + filename, HttpStatus.BAD_REQUEST);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new IndibuException(
                        "Cannot store file with relative path outside current directory " + filename
                        , HttpStatus.FORBIDDEN);
            }
            Files.copy(file.getInputStream(), this.userLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new IndibuException("Failed to store file " + filename + "|" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void uploadDealPhoto(MultipartFile file, long userId, long dealId) {
        Deal deal = dealRepository.findById(dealId);
        User user = userRepository.findById(userId);
        checkerUtill.dealCheck(deal);
        if (!deal.getUser().equals(user)) {
            throw new IndibuException("Fotoğrafı değiştirme yetkiniz bulunmamaktadır.", HttpStatus.UNAUTHORIZED);
        }
        String filename = dealId + "_*_*_.png";
        try {
            if (file.isEmpty()) {
                throw new IndibuException("Failed to store empty file " + filename, HttpStatus.BAD_REQUEST);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new IndibuException(
                        "Cannot store file with relative path outside current directory " + filename
                        , HttpStatus.FORBIDDEN);
            }
            Files.copy(file.getInputStream(), this.dealLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new IndibuException("Failed to store file " + filename + " | " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Path load(String filename, boolean isUser) {
        if (isUser) {
            return userLocation.resolve(filename);
        }
        return dealLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename, boolean isUser) {
        try {
            Path file = load(filename, isUser);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new IndibuException("Could not read file: " + filename, HttpStatus.NOT_FOUND);
            }
        } catch (MalformedURLException e) {
            throw new IndibuException("Could not read file: " + filename + "\n" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
