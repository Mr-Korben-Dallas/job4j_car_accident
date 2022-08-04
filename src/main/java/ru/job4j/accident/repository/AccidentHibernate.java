package ru.job4j.accident.repository;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import java.util.Collection;
import java.util.Optional;

@Repository
public class AccidentHibernate implements HibernateStore {
    private final SessionFactory sessionFactory;

    public AccidentHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Collection<Accident> findAll() {
        return tx(
                session -> {
                    final Query<Accident> query = session.createQuery("from Accident", Accident.class);
                    return query.list();
                },
                sessionFactory
        );
    }

    public void create(Accident accident) {
        tx(session -> session.save(accident), sessionFactory);
    }

    public void update(Accident accident) {
        tx(
                session -> session.createQuery("update Accident set name = :name, text = :text, address = :address where id = :id")
                        .setParameter("name", accident.getName())
                        .setParameter("text", accident.getText())
                        .setParameter("address", accident.getAddress())
                        .setParameter("id", accident.getId())
                        .executeUpdate(),
                sessionFactory
        );
    }

    public Optional<Accident> findById(Long id) {
        return Optional.ofNullable(
                tx(
                        session -> {
                            final Query<Accident> query = session.createQuery("from Accident where id = :id", Accident.class);
                            query.setParameter("id", id);
                            return query.uniqueResult();
                        },
                        sessionFactory
                )
        );
    }
}