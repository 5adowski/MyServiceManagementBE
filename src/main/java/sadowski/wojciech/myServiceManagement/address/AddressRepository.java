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
    public Address insert(Address address) {
        jdbcTemplate.update("INSERT INTO ADDRESS(" +
                        "ZIP_CODE," +
                        "CITY," +
                        "STREET)" +
                        "VALUES (?, ?, ?)",
                address.getZipCode(),
                address.getCity(),
                address.getStreet());
        return setId(address);
    }

    @Override
    public List<Address> selectAll() {
        return jdbcTemplate.query("SELECT * FROM ADDRESS", BeanPropertyRowMapper.newInstance(Address.class));
    }

    @Override
    public Address select(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM ADDRESS WHERE ID = ?", BeanPropertyRowMapper.newInstance(Address.class), id);
    }

    @Override
    public void put(Address address) {
        jdbcTemplate.update("UPDATE ADDRESS SET " +
                        "ZIP_CODE = ?," +
                        "CITY = ?," +
                        "STREET = ?" +
                        "WHERE ID = ?",
                address.getZipCode(),
                address.getCity(),
                address.getStreet(),
                address.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM ADDRESS WHERE ID = ?", id);
    }

    private Address setId(Address address) {
        address.setId(jdbcTemplate.queryForObject("SELECT ID FROM ADDRESS WHERE " +
                "ZIP_CODE = ? AND " +
                "CITY = ? AND " +
                "STREET = ?",
                Long.class,
                address.getZipCode(),
                address.getCity(),
                address.getStreet()));
        return address;
    }
}
