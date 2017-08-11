package com.indibu.indiBuserver.controller;

import com.indibu.indiBuserver.core.Constants;
import com.indibu.indiBuserver.core.SessionUtil;
import com.indibu.indiBuserver.model.ChatResponseList;
import com.indibu.indiBuserver.model.MessageResponseList;
import com.indibu.indiBuserver.model.SendMessageRequestBody;
import com.indibu.indiBuserver.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private SessionUtil sessionUtil;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.POST)
    public void sendMessage(@RequestBody SendMessageRequestBody message) {
        long userId = sessionUtil.getUserId(httpServletRequest);
        messageService.sendMessage(message, userId);
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public MessageResponseList getNewMessages() {
        long userId = (long) httpServletRequest.getSession().getAttribute(Constants.USER_ID_SESSION_ATTRIBUTE);
        return messageService.getNewMessages(userId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public MessageResponseList getMessages(@RequestParam long chatId) {
        long userId = (long) httpServletRequest.getSession().getAttribute(Constants.USER_ID_SESSION_ATTRIBUTE);
        return messageService.getMessages(userId, chatId);
    }

    @RequestMapping(value="/chats",method = RequestMethod.GET)
    public ChatResponseList getChats(){
        long userId = (long) httpServletRequest.getSession().getAttribute(Constants.USER_ID_SESSION_ATTRIBUTE);
        return messageService.getChats(userId);
    }

}
