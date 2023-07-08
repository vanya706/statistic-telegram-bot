package org.ivanmostovyi.statistictelegrambot.helper;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;
import java.util.stream.Collectors;

import static org.ivanmostovyi.statistictelegrambot.constant.ButtonConstants.*;

/**
 * Helper class, allows to build keyboards for users
 */
@Component
public class KeyboardHelper {

    public ReplyKeyboardMarkup buildCitiesMenu(List<String> cities) {
        List<KeyboardButton> buttons = cities.stream()
                .map(KeyboardButton::new)
                .collect(Collectors.toList());

        KeyboardRow row1 = new KeyboardRow(buttons);

        KeyboardRow row2 = new KeyboardRow(List.of(new KeyboardButton(BTN_CANCEL)));

        return ReplyKeyboardMarkup.builder()
                .keyboard(List.of(row1, row2))
                .selective(true)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();
    }

    public ReplyKeyboardMarkup buildMainMenu() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(CREATE_STATISTIC_BUTTON);
        KeyboardRow row2 = new KeyboardRow();
        row2.add(DELETE_STATISTIC_BUTTON);
        KeyboardRow row3 = new KeyboardRow();
        row3.add(ADD_STATISTIC_VALUE_BUTTON);
        KeyboardRow row4 = new KeyboardRow();
        row4.add(VIEW_STATISTIC_SUMMARY_BUTTON);

        return ReplyKeyboardMarkup.builder()
                .keyboard(List.of(row1, row2, row3, row4))
                .selective(true)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();
    }

    public ReplyKeyboardMarkup buildMenuWithCancel() {
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(BTN_CANCEL);

        return ReplyKeyboardMarkup.builder()
                .keyboard(List.of(keyboardRow))
                .selective(true)
                .resizeKeyboard(true)
                .oneTimeKeyboard(true)
                .build();
    }

}
