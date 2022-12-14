package sadowski.wojciech.myServiceManagement.task;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TaskController {
    private TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping(value = ("/task"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> post(@RequestBody Task task) {
        return ResponseEntity.accepted().body(service.create(task));
    }

    @GetMapping(value = "/tasks")
    public List<Task> getAll() {
        return service.readAll();
    }

    @GetMapping("/task/{id}")
    public Task get(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping(value = ("/task"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> put(@RequestBody Task task) {
        return ResponseEntity.accepted().body(service.update(task));
    }

    @DeleteMapping("/task/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
