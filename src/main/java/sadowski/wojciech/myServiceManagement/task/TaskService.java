package sadowski.wojciech.myServiceManagement.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements sadowski.wojciech.myServiceManagement.interfaces.Service<Task> {
    private TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Task order) {
        repository.insert(order);
    }

    @Override
    public List<Task> readAll() {
        return repository.selectAll();
    }

    @Override
    public Task read(Long id) {
        return repository.select(id);
    }
}
