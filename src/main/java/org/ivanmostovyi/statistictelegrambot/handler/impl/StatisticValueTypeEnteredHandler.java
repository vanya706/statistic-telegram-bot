package org.ivanmostovyi.statistictelegrambot.handler.impl;

import lombok.RequiredArgsConstructor;
import org.ivanmostovyi.statistictelegrambot.constant.ChatState;
import org.ivanmostovyi.statistictelegrambot.constant.StatisticValueType;
import org.ivanmostovyi.statistictelegrambot.domain.Statistic;
import org.ivanmostovyi.statistictelegrambot.domain.TelegramChat;
import org.ivanmostovyi.statistictelegrambot.dto.UserRequest;
import org.ivanmostovyi.statistictelegrambot.handler.UserRequestHandler;
import org.ivanmostovyi.statistictelegrambot.helper.StatisticNameHelper;
import org.ivanmostovyi.statistictelegrambot.service.StatisticService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class StatisticValueTypeEnteredHandler extends UserRequestHandler {

    private final StatisticService statisticService;
    private final StatisticNameHelper statisticNameHelper;

    @Override
    public boolean isApplicable(UserRequest request) {
        return isTextMessage(request.getUpdate(), Arrays.stream(StatisticValueType.values()).map(StatisticValueType::getDisplayedName).toArray(String[]::new))
                && request.getChat().getState().equals(ChatState.WAITING_FOR_STATISTIC_VALUE_TYPE);
    }

    @Override
    public void handle(UserRequest userRequest) {
        StatisticValueType valueType = StatisticValueType.valueOfDisplayedName(userRequest.getUpdate().getMessage().getText());
        String name = statisticNameHelper.get(userRequest.getChat().getId());

        Statistic statistic = Statistic.builder()
                .name(name)
                .valueType(valueType)
                .user(userRequest.getUser())
                .build();

        statisticService.create(statistic);

        ReplyKeyboardMarkup replyKeyboardMarkup = keyboardHelper.buildMainMenu();
        telegramService.sendMessage(userRequest.getChat().getId(), "Статистику було створено!", replyKeyboardMarkup);

        TelegramChat chat = userRequest.getChat();
        chat.setState(ChatState.STARTED);
        chatService.update(chat);
    }

    @Override
    public boolean isGlobal() {
        return false;
    }

}
