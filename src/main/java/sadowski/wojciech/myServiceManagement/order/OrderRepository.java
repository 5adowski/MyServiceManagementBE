package sadowski.wojciech.myServiceManagement.order;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository implements sadowski.wojciech.myServiceManagement.interfaces.Repository<Order> {
    private JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Order order) {
        jdbcTemplate.update("INSERT INTO ORDERS(" +
                        "STATUS," +
                        "ID_TECHNICIAN," +
                        "ID_COMPANY," +
                        "ID_CUSTOMER," +
                        "ID_ADDRESS," +
                        "ID_DEVICE)" +
                        "VALUES (?, ?, ?, ?, ?, ?)",
                order.getStatus(),
                order.getIdTechnician(),
                order.getIdCompany(),
                order.getIdCustomer(),
                order.getIdAddress(),
                order.getIdDevice());
    }

    @Override
    public List<Order> selectAll() {
        return jdbcTemplate.query("SELECT * FROM ORDERS", BeanPropertyRowMapper.newInstance(Order.class));
    }

    @Override
    public Order select(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM ORDERS WHERE ID = ?", BeanPropertyRowMapper.newInstance(Order.class), id);
    }
}
