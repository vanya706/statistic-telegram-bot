package org.ivanmostovyi.statistictelegrambot.service;

import lombok.RequiredArgsConstructor;
import org.ivanmostovyi.statistictelegrambot.domain.TelegramUser;
import org.ivanmostovyi.statistictelegrambot.repository.TelegramUserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TelegramUserService extends BaseEntityService<TelegramUser> {

    private final TelegramUserRepository repository;

    @Override
    public TelegramUserRepository getRepository() {
        return repository;
    }

}
