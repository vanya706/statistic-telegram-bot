package org.ivanmostovyi.statistictelegrambot.handler.impl;

import org.ivanmostovyi.statistictelegrambot.constant.ButtonConstants;
import org.ivanmostovyi.statistictelegrambot.handler.UserRequestHandler;
import org.ivanmostovyi.statistictelegrambot.dto.UserRequest;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class CancelHandler extends UserRequestHandler {

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isTextMessage(userRequest.getUpdate(), ButtonConstants.BTN_CANCEL);
    }

    @Override
    public void handle(UserRequest userRequest) {
        ReplyKeyboard replyKeyboard = keyboardHelper.buildMainMenu();
//        telegramService.sendMessage(userRequest.getChatId(),
//                "Обирайте з меню нижче ⤵️", replyKeyboard);

//        UserSession userSession = userRequest.getUserSession();
//        userSession.setState(ConversationState.CONVERSATION_STARTED);
//        userSessionService.saveSession(userSession.getChatId(), userSession);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }

}
