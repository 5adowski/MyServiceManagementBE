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
    public Task insert(Task task) {
        jdbcTemplate.update("INSERT INTO TASK(" +
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
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
                task.getDescription(),
                task.getDate(),
                task.getStartTime(),
                task.getEndTime(),
                task.getMinPrice(),
                task.getMaxPrice(),
                task.getStatus().toString(),
                task.getNotes(),
                task.getIdTechnician(),
                task.getIdCompany(),
                task.getIdCustomer(),
                task.getIdAddress(),
                task.getIdDevice());
        return collectIdentifier(task);
    }

    @Override
    public List<Task> selectAll() {
        return jdbcTemplate.query("SELECT * FROM TASK;", BeanPropertyRowMapper.newInstance(Task.class));
    }

    @Override
    public Task select(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM TASK WHERE ID = ?;", BeanPropertyRowMapper.newInstance(Task.class), id);
    }

    @Override
    public Task put(Task task) {
        jdbcTemplate.update("UPDATE TASK SET " +
                        "DESCRIPTION = ?," +
                        "DATE = ?," +
                        "START_TIME = ?," +
                        "END_TIME = ?," +
                        "MIN_PRICE = ?," +
                        "MAX_PRICE = ?," +
                        "STATUS = ?," +
                        "NOTES = ?," +
                        "ID_TECHNICIAN = ?," +
                        "ID_COMPANY = ?," +
                        "ID_CUSTOMER = ?," +
                        "ID_ADDRESS = ?," +
                        "ID_DEVICE = ? " +
                        "WHERE ID = ?;",
                task.getDescription(),
                task.getDate(),
                task.getStartTime(),
                task.getEndTime(),
                task.getMinPrice(),
                task.getMaxPrice(),
                task.getStatus().toString(),
                task.getNotes(),
                task.getIdTechnician(),
                task.getIdCompany(),
                task.getIdCustomer(),
                task.getIdAddress(),
                task.getIdDevice(),
                task.getId());
        return task;
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM TASK WHERE ID = ?;", id);
    }

    private Task collectIdentifier(Task task) {
        task.setId(jdbcTemplate.queryForObject("SELECT ID FROM TASK WHERE " +
                        "DESCRIPTION = ? AND " +
                        "DATE = ? AND " +
                        "START_TIME = ? AND " +
                        "END_TIME = ? AND " +
                        "MIN_PRICE = ? AND " +
                        "MAX_PRICE = ? AND " +
                        "STATUS = ? AND " +
                        "ID_TECHNICIAN = ? AND " +
                        "ID_CUSTOMER = ? AND " +
                        "ID_ADDRESS = ? AND " +
                        "ID_DEVICE = ?;",
                Long.class,
                task.getDescription(),
                task.getDate(),
                task.getStartTime(),
                task.getEndTime(),
                task.getMinPrice(),
                task.getMaxPrice(),
                task.getStatus().toString(),
                task.getIdTechnician(),
                task.getIdCustomer(),
                task.getIdAddress(),
                task.getIdDevice()));
        return task;
    }

}
