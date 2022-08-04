package ru.job4j.accident.repository;

//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import ru.job4j.accident.model.Accident;
//import ru.job4j.accident.mapper.AccidentMapper;
//import java.util.List;
//import java.util.Optional;

//@Repository
public class AccidentJdbcTemplate {
//    private final JdbcTemplate jdbc;
//    private static final String TABLE_ACCIDENTS_CREATE = "insert INTO ACCIDENTS (NAME, TEXT, ADDRESS) VALUES (?, ?, ?)";
//    private static final String TABLE_ACCIDENTS_FIND_ALL = "SELECT * FROM ACCIDENTS";
//    private static final String TABLE_ACCIDENTS_UPDATE = "UPDATE ACCIDENTS SET NAME = ?, TEXT = ?, ADDRESS = ? WHERE ID = ?";
//    private static final String TABLE_ACCIDENTS_FIND_BY_ID = "SELECT * FROM ACCIDENTS WHERE ID = ?";

//    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }
//
//    public Accident create(Accident accident) {
//        jdbc.update(
//                TABLE_ACCIDENTS_CREATE,
//                accident.getName(),
//                accident.getText(),
//                accident.getAddress()
//        );
//        return accident;
//    }
//
//    public List<Accident> findAll() {
//        return jdbc.query(TABLE_ACCIDENTS_FIND_ALL, new AccidentMapper());
//    }
//
//    public void update(Accident accident) {
//        jdbc.update(
//                TABLE_ACCIDENTS_UPDATE,
//                accident.getName(),
//                accident.getText(),
//                accident.getAddress(),
//                accident.getId()
//        );
//    }
//
//    public Optional<Accident> findById(Long id) {
//        return Optional.ofNullable(jdbc.queryForObject(TABLE_ACCIDENTS_FIND_BY_ID, new AccidentMapper(), id));
//    }
}
