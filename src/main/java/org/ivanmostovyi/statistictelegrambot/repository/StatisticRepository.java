package org.ivanmostovyi.statistictelegrambot.repository;

import org.ivanmostovyi.statistictelegrambot.domain.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {

    List<Statistic> findAllByUserId(Long userId);

}
