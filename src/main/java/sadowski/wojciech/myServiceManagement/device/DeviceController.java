package sadowski.wojciech.myServiceManagement.device;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DeviceController {
    private DeviceService service;

    public DeviceController(DeviceService service) {
        this.service = service;
    }

    @PostMapping(value = ("/device"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Device> post(@RequestBody Device device) {
        return ResponseEntity.accepted().body(service.create(device));
    }

    @GetMapping(value = "/devices")
    public List<Device> getAll() {
        return service.readAll();
    }

    @GetMapping("/device/{id}")
    public Device get(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping(value = ("/device"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Device> put(@RequestBody Device device) {
        return ResponseEntity.accepted().body(service.update(device));
    }

    @DeleteMapping("/device/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
