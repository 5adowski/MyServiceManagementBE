package sadowski.wojciech.myServiceManagement.task.form;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TaskFormController {
    private TaskFormService service;

    public TaskFormController(TaskFormService service) {
        this.service = service;
    }

    @PostMapping(value = ("/task/form"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskForm> post(@RequestBody TaskForm taskForm) {
        return ResponseEntity.accepted().body(service.create(taskForm));
    }

}
