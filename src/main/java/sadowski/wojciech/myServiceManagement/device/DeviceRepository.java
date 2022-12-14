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
        device.setId(createIdentifier(device));
        jdbcTemplate.update("INSERT INTO DEVICE(" +
                        "ID," +
                        "ID_FACTORY," +
                        "ID_FD," +
                        "SERIAL_NUMBER," +
                        "CATALOG_NUMBER," +
                        "ID_ADDRESS)" +
                        "VALUES(?, ?, ?, ?, ?, ?);",
                device.getId(),
                device.getIdFactory(),
                device.getIdFd(),
                device.getSerialNumber(),
                device.getCatalogNumber(),
                device.getIdAddress());
        return device;
    }

    @Override
    public List<Device> selectAll() {
        return jdbcTemplate.query("SELECT * FROM DEVICE;", BeanPropertyRowMapper.newInstance(Device.class));
    }

    @Override
    public Device select(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM DEVICE WHERE ID = ?;", BeanPropertyRowMapper.newInstance(Device.class), id);
    }

    @Override
    public Device put(Device device) {
        jdbcTemplate.update("UPDATE DEVICE SET " +
                        "ID = ?," +
                        "ID_FACTORY = ?," +
                        "ID_FD = ?," +
                        "SERIAL_NUMBER = ?," +
                        "CATALOG_NUMBER = ?," +
                        "ID_ADDRESS = ? " +
                        "WHERE ID = ?;",
                device.getId(),
                device.getIdFactory(),
                device.getIdFd(),
                device.getSerialNumber(),
                device.getCatalogNumber(),
                device.getIdAddress(),
                device.getId());
        return device;
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM DEVICE WHERE ID = ?;", id);
    }

    private Long createIdentifier(Device device) {
        String id = device.getCatalogNumber() + device.getSerialNumber();
        return Long.valueOf(id);
    }

}
