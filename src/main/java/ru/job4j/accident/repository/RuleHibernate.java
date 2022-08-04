package ru.job4j.accident.repository;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;
import java.util.*;

@Repository
public class RuleHibernate implements HibernateStore {
    private final SessionFactory sessionFactory;

    public RuleHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Collection<Rule> findAll() {
        return tx(
                session -> {
                    final Query<Rule> query = session.createQuery("from Rule", Rule.class);
                    return query.list();
                },
                sessionFactory
        );
    }

    public Optional<Rule> findById(Long id) {
        return Optional.ofNullable(
                tx(
                        session -> {
                            final Query<Rule> query = session.createQuery("from Rule where id = :id", Rule.class);
                            query.setParameter("id", id);
                            return query.uniqueResult();
                        },
                        sessionFactory
                )
        );
    }

    public Set<Rule> fetchByIds(ArrayList<Long> ruleIds) {
        return new HashSet<>(tx(session -> session.byMultipleIds(Rule.class).multiLoad(ruleIds), sessionFactory));
    }
}
