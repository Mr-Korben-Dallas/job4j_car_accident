package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.model.RuleMapper;
import java.util.*;

@Repository
public class RuleJdbcTemplate {
    private final JdbcTemplate jdbc;
    private static final String TABLE_RULES_FIND_ALL = "SELECT * FROM RULES";
    private static final String TABLE_RULES_FIND_BY_ID = "SELECT * FROM RULES WHERE ID = ?";
    private static final String TABLE_RULES_FETCH_BY_IDS = "SELECT * FROM RULES WHERE ID IN (%s)";

    public RuleJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Collection<Rule> findAll() {
        return jdbc.query(TABLE_RULES_FIND_ALL, new RuleMapper());    }

    public Optional<Rule> findById(Long id) {
        return Optional.ofNullable(jdbc.queryForObject(TABLE_RULES_FIND_BY_ID, new RuleMapper(), id));
    }

    public Set<Rule> fetchByIds(ArrayList<Long> ruleIds) {
        String inSql = String.join(", ", Collections.nCopies(ruleIds.size(), "?"));
        List<Rule> rulesList = jdbc.query(
                String.format(TABLE_RULES_FETCH_BY_IDS, inSql),
                ruleIds.toArray(),
                new RuleMapper()
        );
        return new HashSet<>(rulesList);
    }
}
