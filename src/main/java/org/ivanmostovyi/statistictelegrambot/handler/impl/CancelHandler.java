package org.ivanmostovyi.statistictelegrambot.handler.impl;

import org.ivanmostovyi.statistictelegrambot.constant.Constants;
import org.ivanmostovyi.statistictelegrambot.enums.ConversationState;
import org.ivanmostovyi.statistictelegrambot.handler.UserRequestHandler;
import org.ivanmostovyi.statistictelegrambot.helper.KeyboardHelper;
import org.ivanmostovyi.statistictelegrambot.model.UserRequest;
import org.ivanmostovyi.statistictelegrambot.model.UserSession;
import org.ivanmostovyi.statistictelegrambot.service.TelegramService;
import org.ivanmostovyi.statistictelegrambot.service.UserSessionService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class CancelHandler extends UserRequestHandler {

    private final TelegramService telegramService;
    private final KeyboardHelper keyboardHelper;
    private final UserSessionService userSessionService;

    public CancelHandler(TelegramService telegramService, KeyboardHelper keyboardHelper, UserSessionService userSessionService) {
        this.telegramService = telegramService;
        this.keyboardHelper = keyboardHelper;
        this.userSessionService = userSessionService;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isTextMessage(userRequest.getUpdate(), Constants.BTN_CANCEL);
    }

    @Override
    public void handle(UserRequest userRequest) {
        ReplyKeyboard replyKeyboard = keyboardHelper.buildMainMenu();
        telegramService.sendMessage(userRequest.getChatId(),
                "Обирайте з меню нижче ⤵️", replyKeyboard);

        UserSession userSession = userRequest.getUserSession();
        userSession.setState(ConversationState.CONVERSATION_STARTED);
        userSessionService.saveSession(userSession.getChatId(), userSession);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}
