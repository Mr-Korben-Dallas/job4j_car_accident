package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentTypeHibernate;

import java.util.Collection;

@Service
public class AccidentTypeService {
    private final AccidentTypeHibernate store;

    public AccidentTypeService(AccidentTypeHibernate store) {
        this.store = store;
    }

    public Collection<AccidentType> findAll() {
        return store.findAll();
    }
}
