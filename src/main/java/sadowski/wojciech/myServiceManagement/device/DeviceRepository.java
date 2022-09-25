package sadowski.wojciech.myServiceManagement.device;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeviceRepository implements sadowski.wojciech.myServiceManagement.interfaces.Repository<Device> {
    private JdbcTemplate jdbcTemplate;

    public DeviceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Device device) {
        jdbcTemplate.update("INSERT INTO DEVICE(" +
                        "ID_FACTORY," +
                        "ID_FD," +
                        "SERIAL_NUMBER," +
                        "CATALOG_NUMBER)" +
                        "VALUES (?, ?, ?, ?)",
                device.getIdFactory(),
                device.getIdFd(),
                device.getSerialNumber(),
                device.getCatalogNumber());
    }

    @Override
    public List<Device> selectAll() {
        return jdbcTemplate.query("SELECT * FROM DEVICE", BeanPropertyRowMapper.newInstance(Device.class));
    }

    @Override
    public Device select(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM DEVICE WHERE ID = ?", BeanPropertyRowMapper.newInstance(Device.class), id);
    }
}
