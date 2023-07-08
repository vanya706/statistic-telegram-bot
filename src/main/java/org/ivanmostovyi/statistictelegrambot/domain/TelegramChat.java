package org.ivanmostovyi.statistictelegrambot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.ivanmostovyi.statistictelegrambot.constant.ChatState;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TelegramChat extends AuditableEntity {

    @Enumerated(EnumType.STRING)
    private ChatState state;

}
