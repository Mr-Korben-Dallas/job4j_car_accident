package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class RuleMem {
    private final Map<Long, Rule> rules = new HashMap();
    private final AtomicLong atomicId = new AtomicLong();

    public RuleMem() {
        rules.put(atomicId.incrementAndGet(), new Rule(atomicId.get(), "Статья 1"));
        rules.put(atomicId.incrementAndGet(), new Rule(atomicId.get(), "Статья 2"));
        rules.put(atomicId.incrementAndGet(), new Rule(atomicId.get(), "Статья 3"));
    }

    public Collection<Rule> findAll() {
        return rules.values();
    }

    public Rule findById(Long id) {
        return rules.get(id);
    }

    public Set<Rule> fetchByIds(ArrayList<Long> ruleIds) {
        Set<Rule> fetchedRules = new HashSet<>();
        ruleIds.forEach(id -> fetchedRules.add(rules.get(id)));
        return fetchedRules;
    }
}
