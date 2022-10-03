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
    public Device insert(Device device) {
        jdbcTemplate.update("INSERT INTO DEVICE(" +
                        "ID," +
                        "ID_FACTORY," +
                        "ID_FD," +
                        "SERIAL_NUMBER," +
                        "CATALOG_NUMBER," +
                        "ID_ADDRESS)" +
                        "VALUES (?, ?, ?, ?, ?, ?)",
                createId(device),
                device.getIdFactory(),
                device.getIdFd(),
                device.getSerialNumber(),
                device.getCatalogNumber(),
                device.getIdAddress());
        return setId(device);
    }

    @Override
    public List<Device> selectAll() {
        return jdbcTemplate.query("SELECT * FROM DEVICE", BeanPropertyRowMapper.newInstance(Device.class));
    }

    @Override
    public Device select(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM DEVICE WHERE ID = ?", BeanPropertyRowMapper.newInstance(Device.class), id);
    }

    @Override
    public void put(Device device) {
        jdbcTemplate.update("UPDATE DEVICE SET " +
                        "ID = ?," +
                        "ID_FACTORY = ?," +
                        "ID_FD = ?," +
                        "SERIAL_NUMBER = ?," +
                        "CATALOG_NUMBER = ?," +
                        "ID_ADDRESS = ? " +
                        "WHERE ID = ?",
                device.getId(),
                device.getIdFactory(),
                device.getIdFd(),
                device.getSerialNumber(),
                device.getCatalogNumber(),
                device.getIdAddress(),
                device.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM DEVICE WHERE ID = ?", id);
    }

    private Long createId(Device device) {
        String id = device.getCatalogNumber() + device.getSerialNumber();
        return Long.valueOf(id);
    }

    private Device setId(Device device) {
        device.setId(jdbcTemplate.queryForObject("SELECT ID FROM DEVICE WHERE " +
                "ID_FACTORY = ? AND " +
                "ID_FD = ? AND " +
                "SERIAL_NUMBER = ? AND " +
                "CATALOG_NUMBER = ? AND " +
                "ID_ADDRESS = ?",
                Long.class,
                device.getIdFactory(),
                device.getIdFd(),
                device.getSerialNumber(),
                device.getCatalogNumber(),
                device.getIdAddress()));
        return device;
    }
}
