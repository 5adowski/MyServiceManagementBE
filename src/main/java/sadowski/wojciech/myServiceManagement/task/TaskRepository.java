package sadowski.wojciech.myServiceManagement.task;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository implements sadowski.wojciech.myServiceManagement.interfaces.Repository<Task> {
    private JdbcTemplate jdbcTemplate;

    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Task order) {
        jdbcTemplate.update("INSERT INTO ORDERS(" +
                        "DESCRIPTION," +
                        "DATE," +
                        "START_TIME," +
                        "END_TIME," +
                        "MIN_PRICE," +
                        "MAX_PRICE," +
                        "STATUS," +
                        "NOTES," +
                        "ID_TECHNICIAN," +
                        "ID_COMPANY," +
                        "ID_CUSTOMER," +
                        "ID_ADDRESS," +
                        "ID_DEVICE)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                order.getDescription(),
                order.getDate(),
                order.getStartTime(),
                order.getEndTime(),
                order.getMinPrice(),
                order.getMaxPrice(),
                order.getStatus(),
                order.getNotes(),
                order.getIdTechnician(),
                order.getIdCompany(),
                order.getIdCustomer(),
                order.getIdAddress(),
                order.getIdDevice());
    }

    @Override
    public List<Task> selectAll() {
        return jdbcTemplate.query("SELECT * FROM ORDERS", BeanPropertyRowMapper.newInstance(Task.class));
    }

    @Override
    public Task select(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM ORDERS WHERE ID = ?", BeanPropertyRowMapper.newInstance(Task.class), id);
    }
}
