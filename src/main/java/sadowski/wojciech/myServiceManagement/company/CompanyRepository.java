package sadowski.wojciech.myServiceManagement.company;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepository implements sadowski.wojciech.myServiceManagement.interfaces.Repository<Company> {
    private JdbcTemplate jdbcTemplate;

    public CompanyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Company company) {
        jdbcTemplate.update("INSERT INTO COMPANY(TIN, NAME, ZIP_CODE, CITY, STREET)VALUES (?, ?, ?, ?, ?)", company.getTIN(), company.getName(), company.getZipCode(), company.getCity(), company.getStreet());
    }

    @Override
    public List<Company> selectAll() {
        return jdbcTemplate.query("SELECT * FROM COMPANY", BeanPropertyRowMapper.newInstance(Company.class));
    }

    @Override
    public Company select(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM COMPANY WHERE ID = ?", BeanPropertyRowMapper.newInstance(Company.class), id);
    }
}
