package org.ivanmostovyi.statistictelegrambot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.ivanmostovyi.statistictelegrambot.domain.TelegramChat;
import org.ivanmostovyi.statistictelegrambot.domain.TelegramUser;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
@Setter
@Builder
public class UserRequest {

    private Update update;
    private TelegramChat chat;
    private TelegramUser user;

}
