package com.indibu.indiBuserver.service;


import com.indibu.indiBuserver.model.ChatResponseList;
import com.indibu.indiBuserver.model.MessageResponseList;
import com.indibu.indiBuserver.model.SendMessageRequestBody;

public interface MessageService {

    void sendMessage(SendMessageRequestBody message, long userId);

    MessageResponseList getNewMessages(long userId);

    MessageResponseList getMessages(long userId, long chatId);

    ChatResponseList getChats(long userId);
}
