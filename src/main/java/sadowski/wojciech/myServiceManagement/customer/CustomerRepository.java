package sadowski.wojciech.myServiceManagement.customer;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository implements sadowski.wojciech.myServiceManagement.interfaces.Repository<Customer> {
    private JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer insert(Customer customer) {
        jdbcTemplate.update("INSERT INTO CUSTOMER(" +
                        "FIRST_NAME," +
                        "LAST_NAME," +
                        "PHONE_NUMBER," +
                        "EMAIL," +
                        "TIN," +
                        "ID_ADDRESSES)" +
                        "VALUES (?, ?, ?, ?, ?, ?)",
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getTin(),
                customer.getIdAddresses());
        return setId(customer);
    }

    @Override
    public List<Customer> selectAll() {
        return jdbcTemplate.query("SELECT * FROM CUSTOMER", BeanPropertyRowMapper.newInstance(Customer.class));
    }

    @Override
    public Customer select(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM CUSTOMER WHERE ID = ?", BeanPropertyRowMapper.newInstance(Customer.class), id);
    }

    @Override
    public void put(Customer customer) {
        jdbcTemplate.update("UPDATE CUSTOMER SET " +
                        "FIRST_NAME = ?," +
                        "LAST_NAME = ?," +
                        "PHONE_NUMBER = ?," +
                        "EMAIL = ?," +
                        "TIN = ?," +
                        "ID_ADDRESSES = ? " +
                        "WHERE ID = ?",
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getTin(),
                customer.getIdAddresses(),
                customer.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM CUSTOMER WHERE ID = ?", id);
    }

    private Customer setId(Customer customer) {
        customer.setId(jdbcTemplate.queryForObject("SELECT ID FROM CUSTOMER WHERE " +
                        "FIRST_NAME = ? AND " +
                        "LAST_NAME = ? AND " +
                        "PHONE_NUMBER = ? AND " +
                        "EMAIL = ? AND " +
                        "TIN = ? AND " +
                        "ID_ADDRESSES = ?", Long.class,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getTin(),
                customer.getIdAddresses(),
                customer.getId()));
        return customer;
    }
}
