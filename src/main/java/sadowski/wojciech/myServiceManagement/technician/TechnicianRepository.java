package sadowski.wojciech.myServiceManagement.technician;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TechnicianRepository implements sadowski.wojciech.myServiceManagement.interfaces.Repository<Technician> {
    private JdbcTemplate jdbcTemplate;

    public TechnicianRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Technician insert(Technician technician) {
        jdbcTemplate.update("INSERT INTO TECHNICIAN(" +
                        "NAME," +
                        "PHONE_NUMBER," +
                        "EMAIL)" +
                        "VALUES (?, ?, ?)",
                technician.getName(),
                technician.getPhoneNumber(),
                technician.getEmail());
        return setId(technician);
    }

    @Override
    public List<Technician> selectAll() {
        return jdbcTemplate.query("SELECT * FROM TECHNICIAN", BeanPropertyRowMapper.newInstance(Technician.class));
    }

    @Override
    public Technician select(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM TECHNICIAN WHERE ID = ?", BeanPropertyRowMapper.newInstance(Technician.class), id);
    }

    @Override
    public void put(Technician technician) {
        jdbcTemplate.update("UPDATE TECHNICIAN SET " +
                        "NAME = ?," +
                        "PHONE_NUMBER = ?," +
                        "EMAIL = ? " +
                        "WHERE ID = ?",
                technician.getName(),
                technician.getPhoneNumber(),
                technician.getEmail(),
                technician.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM TECHNICIAN WHERE ID = ?", id);
    }

    private Technician setId(Technician technician) {
        technician.setId(jdbcTemplate.queryForObject("SELECT ID FROM TECHNICIAN WHERE " +
                        "NAME = ? AND " +
                        "PHONE_NUMBER = ? AND " +
                        "EMAIL = ?",
                Long.class,
                technician.getName(),
                technician.getPhoneNumber(),
                technician.getEmail()));
        return technician;
    }
}
