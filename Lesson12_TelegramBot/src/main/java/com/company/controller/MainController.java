package com.company.controller;

import com.company.container.ComponentContainer;
import com.company.service.CustomerService;
import com.company.util.ReplyKeyboardConstants;
import com.company.util.ReplyKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.*;

import java.util.List;

public class MainController {

    public static void handleMessage(Message message) {
        String chatId = String.valueOf(message.getChatId());

        if(chatId.equals(ComponentContainer.ADMIN_CHAT_ID)){
            AdminController.handleMessage(message);
            return;
        }

        if(message.hasText()){
            handleText(message);
        }else if(message.hasContact()){
            handleContact(message);
        }else if(message.hasLocation()){
            handleLocation(message);
        }else if(message.hasPhoto()){
            handlePhoto(message);
        }else if(message.hasDocument()){
            handleDocument(message);
        }
    }

    private static void handleDocument(Message message) {
        String chatId = String.valueOf(message.getChatId());
        // ...
    }

    private static void handlePhoto(Message message) {
        String chatId = String.valueOf(message.getChatId());
        List<PhotoSize> photoSizeList = message.getPhoto();


    }

    private static void handleLocation(Message message) {
        String chatId = String.valueOf(message.getChatId());
        Location location = message.getLocation();


    }

    private static void handleContact(Message message) {
        String chatId = String.valueOf(message.getChatId());
        Contact contact = message.getContact();

    }

    private static void handleText(Message message) {
        String chatId = String.valueOf(message.getChatId());
        String text = message.getText();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        User user = message.getFrom();

        if(text.equals("/start")){

            CustomerService.addCustomerByChatId(chatId);

            sendMessage.setText("Welcome, "+user.getFirstName());
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.getUserMenu());
            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        }else if(text.equals(ReplyKeyboardConstants.USER_MENU_DEMO)){

        }else if(text.equals(ReplyKeyboardConstants.BASKET_DEMO)){

        }
        else if(text.equals(ReplyKeyboardConstants.MY_ORDERS_DEMO)){
            // todo
        }
        else if(text.equals(ReplyKeyboardConstants.CONTACT_WITH_ADMIN)){
            // todo
        }
    }

    public static void handleCallback(Message message, String data) {

        String chatId = String.valueOf(message.getChatId());

        if(chatId.equals(ComponentContainer.ADMIN_CHAT_ID)){
            AdminController.handleCallback(message, data);
            return;
        }
        // write code here
        System.out.println("chatId = " + chatId);
        System.out.println("data = " + data);

    }
}
