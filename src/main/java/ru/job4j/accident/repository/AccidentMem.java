package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AccidentMem {
    private final AtomicLong accidentId = new AtomicLong();
    List<Accident> accidents = new ArrayList<>();

    public AccidentMem() {
        accidents.add(new Accident(accidentId.incrementAndGet(), "First", "Cur cotta messis?", "None of these ellipses will be lost in tragedies like collision courses in visions", AccidentType.of(1L, "Две машины")));
        accidents.add(new Accident(accidentId.incrementAndGet(), "Second", "Rusticus domuss ducunt ad fuga.", "View oddly like a fantastic cosmonaut.", AccidentType.of(2L, "Машина и человек")));
        accidents.add(new Accident(accidentId.incrementAndGet(), "Third", "Cursuss sunt indictios de emeritis solem.", "Walk without metamorphosis, and we won’t control a kahless.", AccidentType.of(2L, "Машина и человек")));
        accidents.add(new Accident(accidentId.incrementAndGet(), "Fourth", "Ventuss sunt lunas de altus pars.", "Never imitate a transformator.", AccidentType.of(3L, "Машина и велосипед")));
        accidents.add(new Accident(accidentId.incrementAndGet(), "Fifth", "Frondators ortum, tanquam varius calcaria.", "The space suit is virtually crazy.", AccidentType.of(3L, "Машина и велосипед")));
    }

    public Collection<Accident> findAll() {
        return accidents;
    }

    public void createOrUpdate(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(accidentId.incrementAndGet());
            accidents.add(accident);
        } else {
            accidents.set(accident.getId().intValue() - 1, accident);
        }
    }

    public Optional<Accident> findById(Long id) {
        if (accidents.size() < id) {
            return Optional.empty();
        }
        return Optional.ofNullable(accidents.get(id.intValue() - 1));
    }
}
