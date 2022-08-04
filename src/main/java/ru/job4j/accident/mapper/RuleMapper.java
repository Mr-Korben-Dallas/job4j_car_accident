package ru.job4j.accident.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.job4j.accident.model.Rule;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RuleMapper implements RowMapper<Rule> {
    @Override
    public Rule mapRow(ResultSet rs, int rowNum) throws SQLException {
        Rule rule = new Rule();
        rule.setId(rs.getLong("id"));
        rule.setName(rs.getString("name"));
        return rule;
    }
}
