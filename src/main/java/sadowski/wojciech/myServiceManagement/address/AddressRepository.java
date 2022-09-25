package sadowski.wojciech.myServiceManagement.address;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepository implements sadowski.wojciech.myServiceManagement.interfaces.Repository<Address> {
    private JdbcTemplate jdbcTemplate;

    public AddressRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Address address) {
        jdbcTemplate.update("INSERT INTO ADDRESS(" +
                        "ZIP_CODE," +
                        "CITY," +
                        "STREET," +
                        "ID_DEVICES)" +
                        "VALUES (?, ?, ?, ?)",
                address.getZipCode(),
                address.getCity(),
                address.getStreet(),
                address.getIdDevices());
    }

    @Override
    public List<Address> selectAll() {
        return jdbcTemplate.query("SELECT * FROM ADDRESS", BeanPropertyRowMapper.newInstance(Address.class));
    }

    @Override
    public Address select(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM ADDRES WHERE ID = ?", BeanPropertyRowMapper.newInstance(Address.class), id);
    }

    @Override
    public void put(Address address) {
        jdbcTemplate.update("UPDATE ADDRESS SET " +
                "ZIP_CODE = ?," +
                "CITY = ?," +
                "STREET = ?," +
                "ID_DEVICES " +
                "WHERE ID = ?",
                address.getZipCode(),
                address.getCity(),
                address.getStreet(),
                address.getIdDevices(),
                address.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM ADDRESS WHERE ID = ?", id);
    }
}
