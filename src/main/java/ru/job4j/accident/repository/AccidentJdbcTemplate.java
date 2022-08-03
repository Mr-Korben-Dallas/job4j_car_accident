package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentMapper;
import java.util.List;
import java.util.Optional;

@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;
    private final String ACCIDENT_CREATE = "insert into accidents (name, text, address) values (?, ?, ?)";
    private final String ACCIDENT_FIND_ALL = "select * from accidents";
    private final String ACCIDENT_UPDATE = "update accidents set name = ?, text = ?, address = ? where id = ?";
    private final String ACCIDENT_FIND_BY_ID = "select * from accidents where id = ?";

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident create(Accident accident) {
        jdbc.update(
                ACCIDENT_CREATE,
                accident.getName(),
                accident.getText(),
                accident.getAddress()
        );
        return accident;
    }

    public List<Accident> findAll() {
        return jdbc.query(ACCIDENT_FIND_ALL, new AccidentMapper());
    }

    public void update(Accident accident) {
        jdbc.update(
                ACCIDENT_UPDATE,
                accident.getName(),
                accident.getText(),
                accident.getAddress(),
                accident.getId()
        );
    }

    public Optional<Accident> findById(Long id) {
        return Optional.ofNullable(jdbc.queryForObject(ACCIDENT_FIND_BY_ID, new AccidentMapper(), id));
    }
}
