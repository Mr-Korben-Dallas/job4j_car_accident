package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AccidentService {
    private final AccidentRepository store;

    public AccidentService(AccidentRepository store) {
        this.store = store;
    }

    public Collection<Accident> findAll() {
        List<Accident> accidents = new ArrayList<>();
        store.findAll().forEach(accidents::add);
        return accidents;
    }

    public void create(Accident accident) {
        store.save(accident);
    }

    public void update(Accident accident) {
        store.save(accident);
    }

    public Optional<Accident> findById(Long id) {
        return store.findById(id);
    }
}
