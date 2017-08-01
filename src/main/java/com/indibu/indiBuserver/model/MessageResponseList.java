package com.indibu.indiBuserver.model;


import com.indibu.indiBuserver.data.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageResponseList {

    private List<MessageResponseModel> messageResponseList;

    public MessageResponseList() {
    }


    public MessageResponseList(List<Message> messageList) {
        messageResponseList = new ArrayList<>();
        for (Message message : messageList) {
            messageResponseList.add(new MessageResponseModel(message));
        }
    }


    public List<MessageResponseModel> getMessageResponseList() {
        return messageResponseList;
    }

    public void setMessageResponseList(List<MessageResponseModel> messageResponseList) {
        this.messageResponseList = messageResponseList;
    }
}
