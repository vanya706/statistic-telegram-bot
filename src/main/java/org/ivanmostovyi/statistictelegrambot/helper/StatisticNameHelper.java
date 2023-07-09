package org.ivanmostovyi.statistictelegrambot.helper;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StatisticNameHelper {

    private final Map<Long, String> chatId2StatisticNameMap = new HashMap<>();

    public void add(Long chatId, String statisticName) {
        chatId2StatisticNameMap.put(chatId, statisticName);
    }

    public String get(Long chatId) {
        return chatId2StatisticNameMap.get(chatId);
    }

}
