package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AccidentTypeMem {
    private final AtomicLong accidentTypeId = new AtomicLong();
    List<AccidentType> accidentTypes = new ArrayList<>();
    
    public AccidentTypeMem() {
        accidentTypes.add(AccidentType.of(accidentTypeId.incrementAndGet(), "Две машины"));
        accidentTypes.add(AccidentType.of(accidentTypeId.incrementAndGet(), "Машина и человек"));
        accidentTypes.add(AccidentType.of(accidentTypeId.incrementAndGet(), "Машина и велосипед"));
    }

    public Collection<AccidentType> findAll() {
        return accidentTypes;
    }
}
