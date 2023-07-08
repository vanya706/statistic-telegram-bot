package org.ivanmostovyi.statistictelegrambot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ChatHistory extends AuditableEntity {

    private String message;

    @ManyToOne
    private TelegramUser author;

    @ManyToOne
    private TelegramChat chat;

}
