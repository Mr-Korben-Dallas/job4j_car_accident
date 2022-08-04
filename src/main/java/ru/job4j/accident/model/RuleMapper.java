package ru.job4j.accident.model;

import org.springframework.jdbc.core.RowMapper;
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
