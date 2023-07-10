package org.ivanmostovyi.statistictelegrambot.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import org.ivanmostovyi.statistictelegrambot.domain.BaseEntity;

import java.io.Serializable;

public class UseIdOrGenerate extends IdentityGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        if (obj == null) throw new HibernateException(new NullPointerException());

        if ((((BaseEntity) obj).getId()) == null) {
            return super.generate(session, obj);
        } else {
            return ((BaseEntity) obj).getId();
        }
    }

}