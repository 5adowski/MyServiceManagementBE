package sadowski.wojciech.myServiceManagement.company;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements sadowski.wojciech.myServiceManagement.interfaces.Service<Company> {
    private CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Company create(Company company) {
        return repository.insert(company);
    }

    @Override
    public List<Company> readAll() {
        return repository.selectAll();
    }

    @Override
    public Company read(Long tin) {
        return repository.select(tin);
    }

    @Override
    public Company update(Company company) {
        return repository.put(company);
    }

    @Override
    public void delete(Long tin) {
        repository.delete(tin);
    }

}
