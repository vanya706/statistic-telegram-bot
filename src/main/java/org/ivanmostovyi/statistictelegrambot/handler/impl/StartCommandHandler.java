package org.ivanmostovyi.statistictelegrambot.handler.impl;

import org.ivanmostovyi.statistictelegrambot.constant.ChatState;
import org.ivanmostovyi.statistictelegrambot.domain.TelegramChat;
import org.ivanmostovyi.statistictelegrambot.handler.UserRequestHandler;
import org.ivanmostovyi.statistictelegrambot.helper.KeyboardHelper;
import org.ivanmostovyi.statistictelegrambot.dto.UserRequest;
import org.ivanmostovyi.statistictelegrambot.service.TelegramService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class StartCommandHandler extends UserRequestHandler {

    private static String command = "/start";

    private final TelegramService telegramService;
    private final KeyboardHelper keyboardHelper;

    public StartCommandHandler(TelegramService telegramService, KeyboardHelper keyboardHelper) {
        this.telegramService = telegramService;
        this.keyboardHelper = keyboardHelper;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isCommand(userRequest.getUpdate(), command);
    }

    @Override
    public void handle(UserRequest request) {
        ReplyKeyboard replyKeyboard = keyboardHelper.buildMainMenu();
        telegramService.sendMessage(request.getChat().getId(),
                "\uD83D\uDC4BПривіт! За допомогою цього чат-бота Ви зможете відслідковувати статистику яку забажаєте, і переглядати її на графіках!",
                replyKeyboard);
        telegramService.sendMessage(request.getChat().getId(), "Обирайте з меню нижче ⤵️");

        TelegramChat chat = request.getChat();
        chat.setState(ChatState.STARTED);
        chatService.update(chat);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }

}
