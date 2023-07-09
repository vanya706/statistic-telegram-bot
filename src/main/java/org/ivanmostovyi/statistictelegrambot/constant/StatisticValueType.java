package org.ivanmostovyi.statistictelegrambot.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum StatisticValueType {
    LONG("Long"),
    DOUBLE("Double"),
    STRING("String");

    private final String displayedName;

    public static StatisticValueType valueOfDisplayedName(String displayedName) {
        return Arrays.stream(values())
                .filter(statisticValueType -> statisticValueType.getDisplayedName().equals(displayedName))
                .findFirst()
                .get();
    }

}
