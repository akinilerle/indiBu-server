package com.indibu.indiBuserver.model;


import java.util.List;

public class ChatResponseList {

    private List<ChatResponseModel> chatResponseList;

    public ChatResponseList() {
    }

    public ChatResponseList(List<ChatResponseModel> chatResponseList) {
        this.chatResponseList = chatResponseList;
    }

    public List<ChatResponseModel> getChatResponseList() {
        return chatResponseList;
    }

    public void setChatResponseList(List<ChatResponseModel> chatResponseList) {
        this.chatResponseList = chatResponseList;
    }


}
