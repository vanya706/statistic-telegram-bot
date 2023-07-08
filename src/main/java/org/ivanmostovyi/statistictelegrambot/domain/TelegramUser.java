package org.ivanmostovyi.statistictelegrambot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TelegramUser extends AuditableEntity {

    private String firstName;

    private String lastName;

    private String userName;

    @OneToOne
    private TelegramChat chat;

}
