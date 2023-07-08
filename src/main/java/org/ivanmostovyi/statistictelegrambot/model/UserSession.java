package org.ivanmostovyi.statistictelegrambot.model;

import lombok.Builder;
import lombok.Data;
import org.ivanmostovyi.statistictelegrambot.enums.ConversationState;

@Data
@Builder
public class UserSession {
    private Long chatId;
    private ConversationState state;
    private String city;
    private String text;
}
