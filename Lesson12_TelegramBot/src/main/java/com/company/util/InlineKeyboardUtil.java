package com.company.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class InlineKeyboardUtil {

    public static InlineKeyboardMarkup getFileMenuForCategory() {
        InlineKeyboardButton button1 = getButton(
                InlineKeyboardConstants.CATEGORY_PDF_DEMO, InlineKeyboardConstants.CATEGORY_PDF_DATA);
        InlineKeyboardButton button2 = getButton(
                InlineKeyboardConstants.CATEGORY_WORD_DEMO, InlineKeyboardConstants.CATEGORY_WORD_DATA);
        InlineKeyboardButton button3 = getButton(
                InlineKeyboardConstants.CATEGORY_EXCEL_DEMO, InlineKeyboardConstants.CATEGORY_EXCEL_DATA);

        List<InlineKeyboardButton> row = List.of(button1, button2, button3);

        List<List<InlineKeyboardButton>> rowList = List.of(row);

        return new InlineKeyboardMarkup(rowList);
    }

    private static InlineKeyboardButton getButton(String demo, String callbackData) {
        InlineKeyboardButton button = new InlineKeyboardButton(demo);
        button.setCallbackData(callbackData);
        return button;
    }
}
