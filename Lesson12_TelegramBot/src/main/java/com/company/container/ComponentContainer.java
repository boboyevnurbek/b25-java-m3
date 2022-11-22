package com.company.container;

import com.company.Main;
import com.company.bot.MyBot;
import com.company.enums.AdminStatus;

import java.util.HashMap;
import java.util.Map;

public interface ComponentContainer {
    String BOT_TOKEN = "";
    String BOT_USERNAME = "";
    String ADMIN_CHAT_ID = "616525392";
    MyBot MY_BOT = new MyBot();

    // chat id, admin status
    Map<String, AdminStatus> adminStatusMap = new HashMap<>();
}
