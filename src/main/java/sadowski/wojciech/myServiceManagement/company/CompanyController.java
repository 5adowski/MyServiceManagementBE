package sadowski.wojciech.myServiceManagement.company;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class CompanyController {
    private CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping(value = ("/company"),
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Company> post(@RequestBody Company company) {
        service.create(company);
        return ResponseEntity.created(URI.create("/")).body(company);
    }

    @GetMapping("/companies")
    public List<Company> getAll(){
        return service.readAll();
    }

    @GetMapping("/company/{id}")
    public Company get(@PathVariable Long id) {
        return service.read(id);
    }
}