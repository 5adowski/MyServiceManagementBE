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
    public Company insert(Company company) {
        jdbcTemplate.update("INSERT INTO COMPANY(" +
                        "TIN," +
                        "NAME," +
                        "ZIP_CODE," +
                        "CITY," +
                        "STREET)" +
                        "VALUES(?, ?, ?, ?, ?);",
                company.getTin(),
                company.getName(),
                company.getZipCode(),
                company.getCity(),
                company.getStreet());
        return company;
    }

    @Override
    public List<Company> selectAll() {
        return jdbcTemplate.query("SELECT * FROM COMPANY;", BeanPropertyRowMapper.newInstance(Company.class));
    }

    @Override
    public Company select(Long tin) {
        return jdbcTemplate.queryForObject("SELECT * FROM COMPANY WHERE TIN = ?;", BeanPropertyRowMapper.newInstance(Company.class), tin);
    }

    @Override
    public Company put(Company company) {
        jdbcTemplate.update("UPDATE COMPANY SET " +
                        "TIN = ?," +
                        "NAME = ?," +
                        "ZIP_CODE = ?," +
                        "CITY = ?," +
                        "STREET = ? " +
                        "WHERE TIN = ?;",
                company.getTin(),
                company.getName(),
                company.getZipCode(),
                company.getCity(),
                company.getStreet(),
                company.getTin());
        return company;
    }

    @Override
    public void delete(Long tin) {
        jdbcTemplate.update("DELETE FROM COMPANY WHERE TIN = ?;", tin);
    }

}
