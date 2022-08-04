package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.RuleRepository;
import java.util.*;

@Service
public class RuleService {
    private final RuleRepository store;

    public RuleService(RuleRepository store) {
        this.store = store;
    }

    public Collection<Rule> findAll() {
        List<Rule> rules = new ArrayList<>();
        store.findAll().forEach(rules::add);
        return rules;
    }

    public Optional<Rule> findById(Long id) {
        return store.findById(id);
    }

    public Set<Rule> fetchByIds(ArrayList<Long> ruleIds) {
        return new HashSet<>((Collection) store.findAllById(ruleIds));
    }
}
