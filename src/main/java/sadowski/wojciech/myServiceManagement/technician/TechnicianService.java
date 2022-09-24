package sadowski.wojciech.myServiceManagement.technician;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService {
    private TechnicianRepository repository;

    public TechnicianService(TechnicianRepository repository) {
        this.repository = repository;
    }

    public void create(Technician technician) {
        repository.insert(technician);
    }

    public List<Technician> readAll() {
        return repository.selectAll();
    }

    public Technician read(Long id) {
        return repository.select(id);
    }
}
