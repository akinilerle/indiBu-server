package com.indibu.indiBuserver.service;

import com.indibu.indiBuserver.core.CheckerUtill;
import com.indibu.indiBuserver.data.entity.Chat;
import com.indibu.indiBuserver.data.entity.Coupon;
import com.indibu.indiBuserver.data.entity.Message;
import com.indibu.indiBuserver.data.entity.User;
import com.indibu.indiBuserver.data.repository.ChatRepository;
import com.indibu.indiBuserver.data.repository.CouponRepository;
import com.indibu.indiBuserver.data.repository.MessageRepository;
import com.indibu.indiBuserver.data.repository.UserRepository;
import com.indibu.indiBuserver.model.ChatResponseList;
import com.indibu.indiBuserver.model.MessageResponseList;
import com.indibu.indiBuserver.model.SendMessageRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private CheckerUtill checkerUtill;


    @Override
    public void sendMessage(SendMessageRequestBody messageRequestBody, long userId) {
        User sender = userRepository.findById(userId);
        User buyer = sender;
        Coupon coupon = couponRepository.findById(messageRequestBody.getCouponId());
        checkerUtill.userCheck(buyer);
        checkerUtill.couponCheck(coupon);
        User receiver = userRepository.findByNickname(messageRequestBody.getReceiverNickname());

        if (coupon.getUser().equals(buyer)) {
            buyer = receiver;
        }

        Chat chat = chatRepository.findByCouponAndBuyer(coupon, buyer);

        if (chat == null) {
            chat = new Chat(coupon, buyer);
        }
        Message message = new Message(messageRequestBody, coupon, sender);
        chat.getMessageList().add(message);
        messageRepository.save(message);

        chatRepository.save(chat);

        receiver.getNewMessageList().add(message);
        userRepository.save(receiver);

    }

    @Override
    public MessageResponseList getNewMessages(long userId) {

        User user = userRepository.findById(userId);
        checkerUtill.userCheck(user);
        List<Message> messageList = new ArrayList<>(user.getNewMessageList());
        user.getNewMessageList().clear();
        userRepository.save(user);
        return new MessageResponseList(messageList);
    }

    @Override
    public MessageResponseList getMessages(long userId, long chatId) {

        User user = userRepository.findById(userId);
        checkerUtill.userCheck(user);
        Chat chat = chatRepository.findById(chatId);
        if (chat == null) {
            return new MessageResponseList(new ArrayList<>());
        }
        if (!(chat.getBuyer().equals(user) || chat.getSeller().equals(user))) {
            return new MessageResponseList(new ArrayList<>());
        }
        user.getNewMessageList().removeAll(chat.getMessageList());
        userRepository.save(user);
        return new MessageResponseList(chat.getMessageList());
    }

    @Override
    public ChatResponseList getChats(long userId) {
        User user = userRepository.findById(userId);
        checkerUtill.userCheck(user);
        return new ChatResponseList(chatRepository.findAllByBuyerOrSeller(user, user));
    }

}
