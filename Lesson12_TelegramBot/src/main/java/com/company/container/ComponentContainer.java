package com.company.container;

import com.company.Main;
import com.company.bot.MyBot;
import com.company.enums.AdminStatus;
import com.company.enums.UserStatus;

import java.util.HashMap;
import java.util.Map;

public interface ComponentContainer {
    String BOT_TOKEN = "";
    String BOT_USERNAME = "";
    String ADMIN_CHAT_ID = "616525392ABC";
    MyBot MY_BOT = new MyBot();

    // chat id, admin status
    Map<String, AdminStatus> adminStatusMap = new HashMap<>();

    Map<String, UserStatus> userStatusMap = new HashMap<>();

    // chat id, object
    Map<String, Object> adminObjectMap = new HashMap<>();
}
