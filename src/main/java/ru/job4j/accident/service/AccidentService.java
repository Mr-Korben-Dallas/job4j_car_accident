package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;
import java.util.Collection;
import java.util.Optional;

@Service
public class AccidentService {
    private final AccidentMem store;

    public AccidentService(AccidentMem store) {
        this.store = store;
    }

    public Collection<Accident> findAll() {
        return store.findAll();
    }

    public void create(Accident accident) {
        store.create(accident);
    }

    public void update(Accident accident) {
        store.update(accident);
    }

    public Optional<Accident> findById(Long id) {
        return store.findById(id);
    }
}
