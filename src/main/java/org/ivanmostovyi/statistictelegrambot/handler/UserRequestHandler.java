package org.ivanmostovyi.statistictelegrambot.handler;

import org.ivanmostovyi.statistictelegrambot.dto.UserRequest;
import org.ivanmostovyi.statistictelegrambot.helper.KeyboardHelper;
import org.ivanmostovyi.statistictelegrambot.service.TelegramChatService;
import org.ivanmostovyi.statistictelegrambot.service.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;

public abstract class UserRequestHandler {

    @Autowired
    protected KeyboardHelper keyboardHelper;
    @Autowired
    protected TelegramChatService chatService;
    @Autowired
    protected TelegramService telegramService;

    public abstract boolean isApplicable(UserRequest request);

    public abstract void handle(UserRequest userRequest);

    public abstract boolean isGlobal();

    public boolean isCommand(Update update, String command) {
        return update.hasMessage() && update.getMessage().isCommand() && update.getMessage().getText().equals(command);
    }

    public boolean isTextMessage(Update update) {
        return update.hasMessage() && update.getMessage().hasText();
    }

    public boolean isTextMessage(Update update, String text) {
        return update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().equals(text);
    }

    public boolean isTextMessage(Update update, String... texts) {
        return update.hasMessage() && update.getMessage().hasText()
                && (Arrays.stream(texts).anyMatch(text -> update.getMessage().getText().equals(text)));
    }

}