package org.ivanmostovyi.statistictelegrambot.handler.impl;

import org.ivanmostovyi.statistictelegrambot.handler.UserRequestHandler;
import org.ivanmostovyi.statistictelegrambot.dto.UserRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class INeedHelpHandler extends UserRequestHandler {

    public static String I_NEED_HELP = "❗️Потрібна допомога";
    public static List<String> cities = List.of("Київ", "Львів");

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return false;
//        return isTextMessage(userRequest.getUpdate(), I_NEED_HELP);
    }

    @Override
    public void handle(UserRequest userRequest) {
//        ReplyKeyboardMarkup replyKeyboardMarkup = keyboardHelper.buildCitiesMenu(cities);
//        telegramService.sendMessage(userRequest.getChatId(),"Оберіть місто або опишіть вручну⤵️", replyKeyboardMarkup);
//
//        UserSession userSession = userRequest.getUserSession();
//        userSession.setState(ConversationState.WAITING_FOR_CITY);
//        userSessionService.saveSession(userSession.getChatId(), userSession);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }

}
