package org.ivanmostovyi.statistictelegrambot.service;

import lombok.RequiredArgsConstructor;
import org.ivanmostovyi.statistictelegrambot.domain.StatisticValue;
import org.ivanmostovyi.statistictelegrambot.domain.TelegramChat;
import org.ivanmostovyi.statistictelegrambot.repository.StatisticValueRepository;
import org.ivanmostovyi.statistictelegrambot.repository.TelegramChatRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TelegramChatService extends BaseEntityService<TelegramChat> {

    private final TelegramChatRepository repository;

    @Override
    public TelegramChatRepository getRepository() {
        return repository;
    }

}
