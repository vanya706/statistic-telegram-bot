package org.ivanmostovyi.statistictelegrambot.handler.impl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.ivanmostovyi.statistictelegrambot.constant.ChatState;
import org.ivanmostovyi.statistictelegrambot.domain.Statistic;
import org.ivanmostovyi.statistictelegrambot.domain.TelegramChat;
import org.ivanmostovyi.statistictelegrambot.dto.UserRequest;
import org.ivanmostovyi.statistictelegrambot.handler.UserRequestHandler;
import org.ivanmostovyi.statistictelegrambot.service.StatisticService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.ivanmostovyi.statistictelegrambot.constant.ButtonConstants.CREATE_STATISTIC_BUTTON;

@RequiredArgsConstructor
@Component
public class CreateStatisticHandler extends UserRequestHandler {

    private final StatisticService statisticService;

    @Override
    public boolean isApplicable(UserRequest request) {
        return isTextMessage(request.getUpdate(), CREATE_STATISTIC_BUTTON);
    }

    @Override
    public void handle(UserRequest userRequest) {
        List<Statistic> statistics = statisticService.findAllByUserId(userRequest.getUser().getId());

        String statisticNames = statistics.stream()
                .map(Statistic::getName)
                .collect(Collectors.joining("\n"));

        String text = StringUtils.isBlank(statisticNames)
                ? "Введіть назву для нової статистики⤵️"
                : "Введіть назву для нової статистики⤵️\nЗараз у вас існують наступні статистики:\n" + statisticNames;
        telegramService.sendMessage(userRequest.getChat().getId(), text);

        TelegramChat chat = userRequest.getChat();
        chat.setState(ChatState.WAITING_FOR_STATISTIC_NAME);
        chatService.update(chat);
    }

    @Override
    public boolean isGlobal() {
        return false;
    }

}
