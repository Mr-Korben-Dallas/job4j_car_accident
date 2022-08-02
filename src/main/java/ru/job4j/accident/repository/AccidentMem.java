package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AccidentMem {
    private final AtomicLong accidentId = new AtomicLong();
    List<Accident> accidents = new ArrayList<>();

    public AccidentMem() {
        accidents.add(new Accident(accidentId.incrementAndGet(), "First", "Cur cotta messis?", "None of these ellipses will be lost in tragedies like collision courses in visions"));
        accidents.add(new Accident(accidentId.incrementAndGet(), "Second", "Rusticus domuss ducunt ad fuga.", "View oddly like a fantastic cosmonaut."));
        accidents.add(new Accident(accidentId.incrementAndGet(), "Third", "Cursuss sunt indictios de emeritis solem.", "Walk without metamorphosis, and we won’t control a kahless."));
        accidents.add(new Accident(accidentId.incrementAndGet(), "Fourth", "Ventuss sunt lunas de altus pars.", "Never imitate a transformator."));
        accidents.add(new Accident(accidentId.incrementAndGet(), "Fifth", "Frondators ortum, tanquam varius calcaria.", "The space suit is virtually crazy."));
    }

    public Collection<Accident> findAll() {
        return accidents;
    }

    public void create(Accident accident) {
        accident.setId(accidentId.incrementAndGet());
        accidents.add(accident);
    }

}
