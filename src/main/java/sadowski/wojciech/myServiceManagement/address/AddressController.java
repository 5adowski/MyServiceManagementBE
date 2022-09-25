package sadowski.wojciech.myServiceManagement.address;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AddressController {
    private AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping(value = ("/address"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> post(Address address) {
        service.create(address);
        return ResponseEntity.accepted().body(address);
    }

    @GetMapping(value = "/addresses")
    public List<Address> getAll() {
        return service.readAll();
    }

    @GetMapping("/address/{id}")
    public Address get(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping(value = ("/address"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> put(Address address) {
        service.update(address);
        return ResponseEntity.accepted().body(address);
    }

    @DeleteMapping("/address/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
