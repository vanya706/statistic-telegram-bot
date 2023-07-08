package org.ivanmostovyi.statistictelegrambot.handler.impl;

import org.ivanmostovyi.statistictelegrambot.handler.UserRequestHandler;
import org.ivanmostovyi.statistictelegrambot.dto.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class TextEnteredHandler extends UserRequestHandler {

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return false;
//        return isTextMessage(userRequest.getUpdate());
//                && ConversationState.WAITING_FOR_TEXT.equals(userRequest.getUserSession().getState());
    }

    @Override
    public void handle(UserRequest userRequest) {
//        ReplyKeyboardMarkup replyKeyboardMarkup = keyboardHelper.buildMainMenu();
//        telegramService.sendMessage(userRequest.getChatId(),"Дякую, ваше звернення було зареєстровано!", replyKeyboardMarkup);
//
//        String text = userRequest.getUpdate().getMessage().getText();
//
//        UserSession session = userRequest.getUserSession();
//        session.setText(text);
//        session.setState(ConversationState.CONVERSATION_STARTED);
//        userSessionService.saveSession(userRequest.getChatId(), session);
    }

    @Override
    public boolean isGlobal() {
        return false;
    }
}
