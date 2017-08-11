package com.indibu.indiBuserver.controller;

import com.indibu.indiBuserver.core.Constants;
import com.indibu.indiBuserver.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private HttpServletRequest httpServletRequest;
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void uploadUserPhoto(MultipartFile photo, RedirectAttributes redirectAttributes) {
        long userId = (long) httpServletRequest.getSession().getAttribute(Constants.USER_ID_SESSION_ATTRIBUTE);
        photoService.uploadUserPhoto(photo, userId);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + photo.getOriginalFilename());
    }

    @RequestMapping(value = "/deal", method = RequestMethod.POST)
    public void uploadDealPhoto(MultipartFile photo, RedirectAttributes redirectAttributes, @RequestParam long dealId) {
        long userId = (long) httpServletRequest.getSession().getAttribute(Constants.USER_ID_SESSION_ATTRIBUTE);
        photoService.uploadDealPhoto(photo, userId, dealId);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + photo.getOriginalFilename());
    }

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadUserPhoto(@RequestParam String nickname) {
        Resource file = photoService.loadAsResource(nickname + "_*_*_.png", true);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @RequestMapping(value = "/deal/get", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadDealPhoto(@RequestParam long dealId) {
        Resource file = photoService.loadAsResource(dealId + "_*_*_.png", false);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
