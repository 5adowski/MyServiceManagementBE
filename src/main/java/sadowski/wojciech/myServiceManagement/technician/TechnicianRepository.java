package sadowski.wojciech.myServiceManagement.technician;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TechnicianRepository {
    private JdbcTemplate jdbcTemplate;

    public TechnicianRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Technician technician){
        jdbcTemplate.update("INSERT INTO TECHNICIAN(NAME, PHONE_NUMBER, EMAIL)VALUES (?, ?, ?)",
                technician.getName(), technician.getPhoneNumber(), technician.getEmail());
    }

    public List<Technician> selectAll(){
        return jdbcTemplate.query("SELECT * FROM TECHNICIAN", BeanPropertyRowMapper.newInstance(Technician.class));
    }

    public Technician select(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM TECHNICIAN WHERE ID = ?", BeanPropertyRowMapper.newInstance(Technician.class), id);
    }
}
