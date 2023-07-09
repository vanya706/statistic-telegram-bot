package org.ivanmostovyi.statistictelegrambot.constant;

public enum ChatState {
    STARTED,

    WAITING_FOR_STATISTIC_NAME,
    WAITING_FOR_STATISTIC_VALUE_TYPE,

    WAITING_FOR_DELETE_STATISTIC,

    WAITING_FOR_ADD_STATISTIC_VALUE,

}
