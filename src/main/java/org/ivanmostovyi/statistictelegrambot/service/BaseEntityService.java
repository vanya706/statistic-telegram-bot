package org.ivanmostovyi.statistictelegrambot.service;


import org.ivanmostovyi.statistictelegrambot.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class BaseEntityService<T extends BaseEntity> {

    public abstract JpaRepository<T, Long> getRepository();

    public T create(T entity) {
        return getRepository().save(entity);
    }

    public T update(T entity) {
        return getRepository().save(entity);
    }

    public void delete(T entity) {
        getRepository().delete(entity);
    }

    public T getById(Long id) {
        return getRepository().getById(id);
    }

    public Optional<T> findById(Long id) {
        return getRepository().findById(id);
    }

}
