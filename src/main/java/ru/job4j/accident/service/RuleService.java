package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.RuleMem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Service
public class RuleService {
    private final RuleMem store;

    public RuleService(RuleMem store) {
        this.store = store;
    }

    public Collection<Rule> findAll() {
        return store.findAll();
    }

    public Rule findById(Long id) {
        return store.findById(id);
    }

    public Set<Rule> fetchByIds(ArrayList<Long> ruleIds) {
        return store.fetchByIds(ruleIds);
    }
}
