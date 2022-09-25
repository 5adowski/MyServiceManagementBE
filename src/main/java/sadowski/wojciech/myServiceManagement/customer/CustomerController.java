package sadowski.wojciech.myServiceManagement.customer;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sadowski.wojciech.myServiceManagement.company.Company;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class CustomerController {
    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping(value = ("/customer"),
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Customer> post(@RequestBody Customer customer) {
        service.create(customer);
        return ResponseEntity.created(URI.create("/")).body(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAll(){
        return service.readAll();
    }

    @GetMapping("/customer/{id}")
    public Customer get(@PathVariable Long id) {
        return service.read(id);
    }
}
