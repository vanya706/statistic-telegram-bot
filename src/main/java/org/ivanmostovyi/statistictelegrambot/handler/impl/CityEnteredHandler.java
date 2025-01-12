package org.ivanmostovyi.statistictelegrambot.handler.impl;

import org.ivanmostovyi.statistictelegrambot.handler.UserRequestHandler;
import org.ivanmostovyi.statistictelegrambot.dto.UserRequest;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
public class CityEnteredHandler extends UserRequestHandler {

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return false;
//        return isTextMessage(userRequest.getUpdate());
//                && ConversationState.WAITING_FOR_CITY.equals(userRequest.getUserSession().getState());
    }

    @Override
    public void handle(UserRequest userRequest) {
        ReplyKeyboardMarkup replyKeyboardMarkup = keyboardHelper.buildMenuWithCancel();
//        telegramService.sendMessage(userRequest.getChatId(),
//                "✍️Тепер опишіть яка допомога вам потрібна⤵️",
//                replyKeyboardMarkup);
//
//        String city = userRequest.getUpdate().getMessage().getText();
//
//        UserSession session = userRequest.getUserSession();
//        session.setCity(city);
//        session.setState(ConversationState.WAITING_FOR_TEXT);
//        userSessionService.saveSession(userRequest.getChatId(), session);
    }

    @Override
    public boolean isGlobal() {
        return false;
    }

}
