package sadowski.wojciech.myServiceManagement.technician;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService implements sadowski.wojciech.myServiceManagement.interfaces.Service<Technician> {
    private TechnicianRepository repository;

    public TechnicianService(TechnicianRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Technician technician) {
        repository.insert(technician);
    }

    @Override
    public List<Technician> readAll() {
        return repository.selectAll();
    }

    @Override
    public Technician read(Long id) {
        return repository.select(id);
    }
}
