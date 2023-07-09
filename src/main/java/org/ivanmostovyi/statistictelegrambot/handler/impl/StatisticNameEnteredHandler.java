package org.ivanmostovyi.statistictelegrambot.handler.impl;

import lombok.RequiredArgsConstructor;
import org.ivanmostovyi.statistictelegrambot.constant.ChatState;
import org.ivanmostovyi.statistictelegrambot.domain.TelegramChat;
import org.ivanmostovyi.statistictelegrambot.dto.UserRequest;
import org.ivanmostovyi.statistictelegrambot.handler.UserRequestHandler;
import org.ivanmostovyi.statistictelegrambot.helper.StatisticNameHelper;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class StatisticNameEnteredHandler extends UserRequestHandler {

    private final StatisticNameHelper statisticNameHelper;

    @Override
    public boolean isApplicable(UserRequest request) {
        return isTextMessage(request.getUpdate())
                && request.getChat().getState().equals(ChatState.WAITING_FOR_STATISTIC_NAME);
    }

    @Override
    public void handle(UserRequest userRequest) {
        String statisticName = userRequest.getUpdate().getMessage().getText().trim();

        statisticNameHelper.add(userRequest.getChat().getId(), statisticName);

        ReplyKeyboardMarkup replyKeyboardMarkup = keyboardHelper.buildStatisticValueTypeMenu();
        telegramService.sendMessage(userRequest.getChat().getId(), "Виберіть тип значень які будуть зберігатись у статистиці з меню нижче ⤵️", replyKeyboardMarkup);

        TelegramChat chat = userRequest.getChat();
        chat.setState(ChatState.WAITING_FOR_STATISTIC_VALUE_TYPE);
        chatService.update(chat);
    }

    @Override
    public boolean isGlobal() {
        return false;
    }

}
