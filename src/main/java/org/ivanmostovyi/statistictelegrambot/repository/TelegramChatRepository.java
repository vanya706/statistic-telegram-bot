package org.ivanmostovyi.statistictelegrambot.repository;

import org.ivanmostovyi.statistictelegrambot.domain.StatisticValue;
import org.ivanmostovyi.statistictelegrambot.domain.TelegramChat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramChatRepository extends JpaRepository<TelegramChat, Long> {


}
