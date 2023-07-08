package org.ivanmostovyi.statistictelegrambot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.ivanmostovyi.statistictelegrambot.constant.StatisticValueType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Statistic extends AuditableEntity {

    private String name;

    private boolean deleted;

    @Enumerated(EnumType.STRING)
    private StatisticValueType valueType;

    @ManyToOne
    private TelegramUser user;

}
