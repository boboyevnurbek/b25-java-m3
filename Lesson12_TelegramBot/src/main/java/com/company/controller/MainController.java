package com.company.controller;

import com.company.container.ComponentContainer;
import com.company.db.Database;
import com.company.entity.BasketDetail;
import com.company.entity.Product;
import com.company.service.BasketDetailService;
import com.company.service.CustomerService;
import com.company.service.ProductService;
import com.company.util.InlineKeyboardConstants;
import com.company.util.InlineKeyboardUtil;
import com.company.util.ReplyKeyboardConstants;
import com.company.util.ReplyKeyboardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.List;

public class MainController {

    public static void handleMessage(Message message) {
        String chatId = String.valueOf(message.getChatId());

        if (chatId.equals(ComponentContainer.ADMIN_CHAT_ID)) {
            AdminController.handleMessage(message);
            return;
        }

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

        User user = message.getFrom();

        if (text.equals("/start")) {

            CustomerService.addCustomerByChatId(chatId);

            sendMessage.setText("Welcome, " + user.getFirstName());
            sendMessage.setReplyMarkup(ReplyKeyboardUtil.getUserMenu());
            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        } else if (text.equals(ReplyKeyboardConstants.USER_MENU_DEMO)) {
            sendMessage.setText("Choose category");
            sendMessage.setReplyMarkup(InlineKeyboardUtil.getInlineMarkupByCategories(
                    InlineKeyboardConstants.CATEGORY_ORDER_DATA
            ));
            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        } else if (text.equals(ReplyKeyboardConstants.BASKET_DEMO)) {
            showBasket(chatId);
        } else if (text.equals(ReplyKeyboardConstants.MY_ORDERS_DEMO)) {
            // todo
        } else if (text.equals(ReplyKeyboardConstants.CONTACT_WITH_ADMIN)) {
            // todo
        }
    }

    private static void showBasket(String chatId) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        List<BasketDetail> basketDetailList = BasketDetailService.getBasket(chatId);

        if(basketDetailList.isEmpty()){
            sendMessage.setText("Basket is empty");
        }else{
            StringBuilder sb = new StringBuilder("Products: \n\n");
            double totalPrice = 0;
            for (BasketDetail basketDetail : basketDetailList) {
                Product product = ProductService.getProductById(basketDetail.getProductId());

                sb.append(product.getName());
                sb.append(" x ");
                sb.append(basketDetail.getQuantity());
                sb.append(" = ");
                sb.append(basketDetail.getQuantity()*product.getPrice());
                sb.append("\n");

                totalPrice += basketDetail.getQuantity()*product.getPrice();
            }

            sb.append("\nTotal price :   ").append(totalPrice);
            sendMessage.setText(sb.toString());
            sendMessage.setReplyMarkup(InlineKeyboardUtil.getBasketMenu(chatId));
        }

        ComponentContainer.MY_BOT.sendMsg(sendMessage);
    }

    public static void handleCallback(Message message, String data) {

        String chatId = String.valueOf(message.getChatId());

        if (chatId.equals(ComponentContainer.ADMIN_CHAT_ID)) {
            AdminController.handleCallback(message, data);
            return;
        }
        // write code here
        System.out.println("chatId = " + chatId);
        System.out.println("data = " + data);

        if (data.startsWith(InlineKeyboardConstants.CATEGORY_ORDER_DATA)) {
            Integer categoryId = Integer.parseInt(data.split("/")[1]);

            List<Product> productList = ProductService.getProductListByCategoryId(categoryId);

            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId(message.getMessageId());

            if (productList.isEmpty()) {
                editMessageText.setText("No products by this category");
            } else {
                editMessageText.setText("Choose product");
                editMessageText.setReplyMarkup(InlineKeyboardUtil.getInlineMarkupByProducts(
                        InlineKeyboardConstants.PRODUCT_ORDER_DATA, productList
                ));
            }

            ComponentContainer.MY_BOT.sendMsg(editMessageText);
        } else if (data.startsWith(InlineKeyboardConstants.PRODUCT_ORDER_DATA)) {
            Integer productId = Integer.parseInt(data.split("/")[1]);

            Product product = ProductService.getProductById(productId);

            if (product == null) {
                EditMessageText editMessageText = new EditMessageText();
                editMessageText.setChatId(chatId);
                editMessageText.setMessageId(message.getMessageId());
                editMessageText.setText("Product not found");

                ComponentContainer.MY_BOT.sendMsg(editMessageText);
            } else {

                DeleteMessage deleteMessage = new DeleteMessage(chatId, message.getMessageId());
                ComponentContainer.MY_BOT.sendMsg(deleteMessage);

                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setPhoto(new InputFile(product.getImageUrl()));
                sendPhoto.setCaption(product.detailInfo());
                sendPhoto.setReplyMarkup(InlineKeyboardUtil.getProductCountMenu(productId, 1));
                ComponentContainer.MY_BOT.sendMsg(sendPhoto);
            }
        } else if (data.startsWith(InlineKeyboardConstants.PRODUCT_QUANTITY_DATA)) {
            // data = InlineKeyboardConstants.PRODUCT_QUANTITY_DATA+"/"+productQuantity+"/-1"
            // data = InlineKeyboardConstants.PRODUCT_QUANTITY_DATA+"/"+productQuantity+"/1"

            String[] parts = data.split("/");
            int productQuantity = Integer.parseInt(parts[1]);
            int sign = Integer.parseInt(parts[2]);
            int productId = Integer.parseInt(parts[3]);

            InlineKeyboardMarkup inlineKeyboardMarkup = InlineKeyboardUtil.getProductCountMenu(
                    productId, Math.max(productQuantity + sign, 1));

            EditMessageReplyMarkup editMessageReplyMarkup = new EditMessageReplyMarkup();
            editMessageReplyMarkup.setChatId(chatId);
            editMessageReplyMarkup.setMessageId(message.getMessageId());
            editMessageReplyMarkup.setReplyMarkup(inlineKeyboardMarkup);

            ComponentContainer.MY_BOT.sendMsg(editMessageReplyMarkup);

        } else if (data.startsWith(InlineKeyboardConstants.PRODUCT_QUANTITY_BASKET_DATA)) {
            // data = InlineKeyboardConstants.PRODUCT_QUANTITY_BASKET_DATA + "/"+productId+"/"+productQuantity

            String[] parts = data.split("/");
            int productId = Integer.parseInt(parts[1]);
            int productQuantity = Integer.parseInt(parts[2]);

            List<BasketDetail> basketDetailList = BasketDetailService.getBasket(chatId);

            BasketDetail basketDetail = basketDetailList.stream()
                    .filter(bd-> bd.getProductId().equals(productId))
                    .findFirst().orElse(null);

            if(basketDetail == null){
                basketDetail = new BasketDetail(chatId, productId, productQuantity);
                Database.BASKET_DETAIL_LIST.add(basketDetail);
            }else{
                basketDetail.setQuantity(basketDetail.getQuantity()+productQuantity);
            }

            DeleteMessage deleteMessage = new DeleteMessage(chatId, message.getMessageId());
            ComponentContainer.MY_BOT.sendMsg(deleteMessage);

            Product product = ProductService.getProductById(productId);

            SendMessage sendMessage = new SendMessage(chatId, product.getName()+" added to basket");
            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        }else if(data.startsWith(InlineKeyboardConstants.PRODUCT_REMOVE_FROM_BASKET_DATA)){
            Integer productId = Integer.valueOf(data.split("/")[1]);

            Database.BASKET_DETAIL_LIST.removeIf(basketDetail -> basketDetail.getChatId().equals(chatId) && basketDetail.getProductId().equals(productId));

            DeleteMessage deleteMessage = new DeleteMessage(chatId, message.getMessageId());
            ComponentContainer.MY_BOT.sendMsg(deleteMessage);

            showBasket(chatId);
        }else if(data.equals(InlineKeyboardConstants.PRODUCT_CLEAN_BASKET_DATA)){

            Database.BASKET_DETAIL_LIST.removeIf(basketDetail -> basketDetail.getChatId().equals(chatId));

            DeleteMessage deleteMessage = new DeleteMessage(chatId, message.getMessageId());
            ComponentContainer.MY_BOT.sendMsg(deleteMessage);

            showBasket(chatId);
        }else if(data.equals(InlineKeyboardConstants.PRODUCT_BUY_BASKET_DATA)){

            // todo: get contact, send message to admin about order with buttons (confirm order, cancel order)

            Database.BASKET_DETAIL_LIST.removeIf(basketDetail -> basketDetail.getChatId().equals(chatId));

            DeleteMessage deleteMessage = new DeleteMessage(chatId, message.getMessageId());
            ComponentContainer.MY_BOT.sendMsg(deleteMessage);

            showBasket(chatId);

            SendMessage sendMessage = new SendMessage(chatId, "Our managers will contact with you");
            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        }
    }
}
