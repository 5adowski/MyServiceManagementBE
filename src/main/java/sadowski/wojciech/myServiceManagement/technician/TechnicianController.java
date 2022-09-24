package sadowski.wojciech.myServiceManagement.technician;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class TechnicianController {
    private TechnicianService service;

    public TechnicianController(TechnicianService service) {
        this.service = service;
    }

    @PostMapping(value = ("/technician"),
    consumes = {MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Technician> post(@RequestBody Technician technician) {
        service.create(technician);
        return ResponseEntity.created(URI.create("/")).body(technician);
    }

    @GetMapping("/technicians")
    public List<Technician> getAll(){
        return service.readAll();
    }

    @GetMapping("/technician/{id}")
    public Technician get(@PathVariable Long id) {
        return service.read(id);
    }
}
