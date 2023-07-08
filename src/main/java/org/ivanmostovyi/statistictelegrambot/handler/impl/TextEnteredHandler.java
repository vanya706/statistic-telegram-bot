package org.ivanmostovyi.statistictelegrambot.handler.impl;

import org.ivanmostovyi.statistictelegrambot.enums.ConversationState;
import org.ivanmostovyi.statistictelegrambot.handler.UserRequestHandler;
import org.ivanmostovyi.statistictelegrambot.helper.KeyboardHelper;
import org.ivanmostovyi.statistictelegrambot.model.UserRequest;
import org.ivanmostovyi.statistictelegrambot.model.UserSession;
import org.ivanmostovyi.statistictelegrambot.service.TelegramService;
import org.ivanmostovyi.statistictelegrambot.service.UserSessionService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
public class TextEnteredHandler extends UserRequestHandler {

    private final TelegramService telegramService;
    private final KeyboardHelper keyboardHelper;
    private final UserSessionService userSessionService;

    public TextEnteredHandler(TelegramService telegramService, KeyboardHelper keyboardHelper, UserSessionService userSessionService) {
        this.telegramService = telegramService;
        this.keyboardHelper = keyboardHelper;
        this.userSessionService = userSessionService;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isTextMessage(userRequest.getUpdate())
                && ConversationState.WAITING_FOR_TEXT.equals(userRequest.getUserSession().getState());
    }

    @Override
    public void handle(UserRequest userRequest) {
        ReplyKeyboardMarkup replyKeyboardMarkup = keyboardHelper.buildMainMenu();
        telegramService.sendMessage(userRequest.getChatId(),"Дякую, ваше звернення було зареєстровано!", replyKeyboardMarkup);

        String text = userRequest.getUpdate().getMessage().getText();

        UserSession session = userRequest.getUserSession();
        session.setText(text);
        session.setState(ConversationState.CONVERSATION_STARTED);
        userSessionService.saveSession(userRequest.getChatId(), session);
    }

    @Override
    public boolean isGlobal() {
        return false;
    }
}
