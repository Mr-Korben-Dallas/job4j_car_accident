package ru.job4j.accident.repository;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;
import java.util.Collection;

@Repository
public class AccidentTypeHibernate implements HibernateStore {
    private final SessionFactory sessionFactory;

    public AccidentTypeHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Collection<AccidentType> findAll() {
        return tx(
                session -> {
                    final Query<AccidentType> query = session.createQuery("from AccidentType", AccidentType.class);
                    return query.list();
                },
                sessionFactory
        );
    }
}
