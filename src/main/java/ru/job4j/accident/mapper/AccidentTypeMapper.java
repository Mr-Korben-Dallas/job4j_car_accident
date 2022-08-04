package ru.job4j.accident.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.job4j.accident.model.AccidentType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccidentTypeMapper implements RowMapper<AccidentType> {
    @Override
    public AccidentType mapRow(ResultSet rs, int rowNum) throws SQLException {
        AccidentType accidentType = new AccidentType();
        accidentType.setId(rs.getLong("id"));
        accidentType.setName(rs.getString("name"));
        return accidentType;
    }
}
