package org.ivanmostovyi.statistictelegrambot.service;

import lombok.RequiredArgsConstructor;
import org.ivanmostovyi.statistictelegrambot.domain.StatisticValue;
import org.ivanmostovyi.statistictelegrambot.repository.StatisticValueRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StatisticValueService extends BaseEntityService<StatisticValue> {

    private final StatisticValueRepository repository;

    @Override
    public StatisticValueRepository getRepository() {
        return repository;
    }

}
