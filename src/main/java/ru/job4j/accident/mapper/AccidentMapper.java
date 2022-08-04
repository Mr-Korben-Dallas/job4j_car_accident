package ru.job4j.accident.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.job4j.accident.model.Accident;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccidentMapper implements RowMapper<Accident> {
    @Override
    public Accident mapRow(ResultSet rs, int rowNum) throws SQLException {
        Accident accident = new Accident();
        accident.setId(rs.getLong("id"));
        accident.setName(rs.getString("name"));
        accident.setText(rs.getString("text"));
        accident.setAddress(rs.getString("address"));
        return accident;
    }
}
