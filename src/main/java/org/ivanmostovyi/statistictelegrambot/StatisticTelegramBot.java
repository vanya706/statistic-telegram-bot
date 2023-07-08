package org.ivanmostovyi.statistictelegrambot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ivanmostovyi.statistictelegrambot.constant.ChatState;
import org.ivanmostovyi.statistictelegrambot.domain.TelegramChat;
import org.ivanmostovyi.statistictelegrambot.domain.TelegramUser;
import org.ivanmostovyi.statistictelegrambot.dto.UserRequest;
import org.ivanmostovyi.statistictelegrambot.service.TelegramChatService;
import org.ivanmostovyi.statistictelegrambot.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@RequiredArgsConstructor
@Component
public class StatisticTelegramBot extends TelegramLongPollingBot {

    @Value("${bot.token}")
    private String botToken;

    @Value("${bot.username}")
    private String botUsername;

    private final Dispatcher dispatcher;
    private final TelegramUserService userService;
    private final TelegramChatService chatService;

    /**
     * This is an entry point for any messages, or updates received from user<br>
     * Docs for "Update object: https://core.telegram.org/bots/api#update
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String textFromUser = update.getMessage().getText();

            Long userId = update.getMessage().getFrom().getId();
            String userFirstName = update.getMessage().getFrom().getFirstName();

            log.info("[{}, {}] : {}", userId, userFirstName, textFromUser);

            Long chatId = update.getMessage().getChatId();

            TelegramUser user = userService.findById(userId)
                    .orElseGet(() -> {
                        TelegramUser newUser = TelegramUser.builder()
                                .id(userId)
                                .firstName(update.getMessage().getFrom().getFirstName())
                                .lastName(update.getMessage().getFrom().getLastName())
                                .userName(update.getMessage().getFrom().getUserName())
                                .build();
                        return userService.create(newUser);
                    });

            TelegramChat chat = chatService.findById(userId)
                    .orElseGet(() -> {
                        TelegramChat newChat = TelegramChat.builder()
                                .id(chatId)
                                .state(ChatState.STARTED)
                                .build();
                        return chatService.create(newChat);
                    });

            UserRequest userRequest = UserRequest
                    .builder()
                    .update(update)
                    .user(user)
                    .chat(chat)
                    .build();

            boolean dispatched = dispatcher.dispatch(userRequest);

            if (!dispatched) {
                log.warn("Unexpected update from user");
            }
        } else {
            log.warn("Unexpected update from user");
        }
    }


    @Override
    public String getBotUsername() {
        // username which you give to your bot bia BotFather (without @)
        return botUsername;
    }

    @Override
    public String getBotToken() {
        // do not expose the token to the repository,
        // always provide it externally(for example as environmental variable)
        return botToken;
    }

}