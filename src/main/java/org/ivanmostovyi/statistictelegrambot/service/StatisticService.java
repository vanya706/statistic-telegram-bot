package org.ivanmostovyi.statistictelegrambot.service;

import lombok.RequiredArgsConstructor;
import org.ivanmostovyi.statistictelegrambot.domain.Statistic;
import org.ivanmostovyi.statistictelegrambot.repository.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StatisticService extends BaseEntityService<Statistic> {

    private final StatisticRepository repository;

    public List<Statistic> findAllByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public StatisticRepository getRepository() {
        return repository;
    }

}
