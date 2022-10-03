package sadowski.wojciech.myServiceManagement.task;

import org.springframework.stereotype.Service;
import sadowski.wojciech.myServiceManagement.status.Status;

import java.util.List;

@Service
public class TaskService implements sadowski.wojciech.myServiceManagement.interfaces.Service<Task> {
    private TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task create(Task task) {
        task.setStatus(Status.CREATED);
        return repository.insert(task);
    }

    @Override
    public List<Task> readAll() {
        return repository.selectAll();
    }

    @Override
    public Task read(Long id) {
        return repository.select(id);
    }

    @Override
    public void update(Task task) {
        repository.put(task);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
