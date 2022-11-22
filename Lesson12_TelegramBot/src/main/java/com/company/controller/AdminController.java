package com.company.controller;

import com.company.container.ComponentContainer;
import com.company.db.Database;
import com.company.entity.Category;
import com.company.enums.AdminStatus;
import com.company.service.CategoryService;
import com.company.util.ReplyKeyboardConstants;
import com.company.util.ReplyKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class AdminController {
    public static void handleMessage(Message message) {

        if (message.hasText()) {
            handleText(message);
        } else if (message.hasContact()) {
            handleContact(message);
        } else if (message.hasLocation()) {
            handleLocation(message);
        } else if (message.hasPhoto()) {
            handlePhoto(message);
        } else if (message.hasDocument()) {
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

        if (text.equals("/start")) {
            sendMessage.setText("Welcome, admin!");
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.getAdminMenu());
            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        }
        else if(text.equals(ReplyKeyboardConstants.CATEGORY_DEMO)){
            sendMessage.setText("Choose operation:");
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.getCategoryCRUDMenu());
            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        }
        else if(text.equals(ReplyKeyboardConstants.PRODUCT_DEMO)){

        }
        else if(text.equals(ReplyKeyboardConstants.CATEGORY_ADD)){
            sendMessage.setText("Enter category name:");
            sendMessage.setReplyMarkup(new ReplyKeyboardRemove(true));
            ComponentContainer.MY_BOT.sendMsg(sendMessage);

            ComponentContainer.adminStatusMap.put(chatId, AdminStatus.ENTER_CATEGORY_NAME_FOR_ADD);
        }
        else if(text.equals(ReplyKeyboardConstants.CATEGORY_EDIT)){

        }
        else if(text.equals(ReplyKeyboardConstants.CATEGORY_DELETE)){

        }
        else if(text.equals(ReplyKeyboardConstants.CATEGORY_LIST)){
            if(Database.CATEGORY_LIST.isEmpty()){
                sendMessage.setText("No categories");
                ComponentContainer.MY_BOT.sendMsg(sendMessage);

            }else{
                String reduce = Database.CATEGORY_LIST.stream()
                        .map(Category::toString)
                        .reduce("", (s, s2) -> s + "\n" + s2);

                sendMessage.setText(reduce);
                ComponentContainer.MY_BOT.sendMsg(sendMessage);
            }
        }
        else if(text.equals(ReplyKeyboardConstants.BACK_FROM_CATEGORY_MENU)){

        }else{
            if(ComponentContainer.adminStatusMap.containsKey(chatId)){
                AdminStatus adminStatus = ComponentContainer.adminStatusMap.get(chatId);

                if(adminStatus.equals(AdminStatus.ENTER_CATEGORY_NAME_FOR_ADD)){
                    String response = CategoryService.addCategory(text);
                    sendMessage.setText(response);
                    sendMessage.setReplyMarkup(ReplyKeyboardUtil.getCategoryCRUDMenu());
                    ComponentContainer.MY_BOT.sendMsg(sendMessage);

                    ComponentContainer.adminStatusMap.remove(chatId);
                }
            }
        }

    }

    public static void handleCallback(Message message, String data) {

    }
}
