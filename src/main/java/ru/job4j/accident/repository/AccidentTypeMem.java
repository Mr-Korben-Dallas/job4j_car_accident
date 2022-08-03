package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AccidentTypeMem {
    private final AtomicLong accidentTypeId = new AtomicLong();
    private final Map<Long, AccidentType> accidentTypes = new HashMap<>();
    
    public AccidentTypeMem() {
        accidentTypes.put(accidentTypeId.incrementAndGet(), AccidentType.of(accidentTypeId.get(), "Две машины"));
        accidentTypes.put(accidentTypeId.incrementAndGet(), AccidentType.of(accidentTypeId.get(), "Машина и человек"));
        accidentTypes.put(accidentTypeId.incrementAndGet(), AccidentType.of(accidentTypeId.get(), "Машина и велосипед"));
    }

    public Collection<AccidentType> findAll() {
        return accidentTypes.values();
    }
}
