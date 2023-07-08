package org.ivanmostovyi.statistictelegrambot.repository;

import org.ivanmostovyi.statistictelegrambot.domain.StatisticValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticValueRepository extends JpaRepository<StatisticValue, Long> {


}
