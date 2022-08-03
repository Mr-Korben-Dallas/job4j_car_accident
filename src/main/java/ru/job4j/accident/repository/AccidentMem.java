package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AccidentMem {
    private final AtomicLong accidentId = new AtomicLong();
    private final Map<Long, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        accidents.put(accidentId.incrementAndGet(), new Accident(accidentId.get(), "First", "Cur cotta messis?", "None of these ellipses will be lost in tragedies like collision courses in visions", AccidentType.of(1L, "Две машины")));
        accidents.put(accidentId.incrementAndGet(), new Accident(accidentId.get(), "Second", "Rusticus domuss ducunt ad fuga.", "View oddly like a fantastic cosmonaut.", AccidentType.of(2L, "Машина и человек")));
        accidents.put(accidentId.incrementAndGet(), new Accident(accidentId.get(), "Third", "Cursuss sunt indictios de emeritis solem.", "Walk without metamorphosis, and we won’t control a kahless.", AccidentType.of(2L, "Машина и человек")));
        accidents.put(accidentId.incrementAndGet(), new Accident(accidentId.get(), "Fourth", "Ventuss sunt lunas de altus pars.", "Never imitate a transformator.", AccidentType.of(3L, "Машина и велосипед")));
        accidents.put(accidentId.incrementAndGet(), new Accident(accidentId.get(), "Fifth", "Frondators ortum, tanquam varius calcaria.", "The space suit is virtually crazy.", AccidentType.of(3L, "Машина и велосипед")));
    }

    public Collection<Accident> findAll() {
        return accidents.values();
    }

    public void create(Accident accident) {
        accident.setId(accidentId.incrementAndGet());
        accidents.put(accident.getId(), accident);
    }

    public void update(Accident accident) {
        accidents.replace(accident.getId(), accident);
    }

    public Optional<Accident> findById(Long id) {
        return Optional.ofNullable(accidents.get(id));
    }
}
