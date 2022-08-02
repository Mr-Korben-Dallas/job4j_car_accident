package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Arrays;
import java.util.Collection;

@Repository
public class AccidentMem {
    public Collection<Accident> findAll() {
        return Arrays.asList(
                new Accident(1L, "First", "Cur cotta messis?", "None of these ellipses will be lost in tragedies like collision courses in visions"),
                new Accident(2L, "Second", "Rusticus domuss ducunt ad fuga.", "View oddly like a fantastic cosmonaut."),
                new Accident(3L, "Third", "Cursuss sunt indictios de emeritis solem.", "Walk without metamorphosis, and we won’t control a kahless."),
                new Accident(4L, "Fourth", "Ventuss sunt lunas de altus pars.", "Never imitate a transformator."),
                new Accident(5L, "Fifth", "Frondators ortum, tanquam varius calcaria.", "The space suit is virtually crazy.")
        );
    }
}
