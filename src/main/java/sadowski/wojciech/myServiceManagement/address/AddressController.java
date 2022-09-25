package sadowski.wojciech.myServiceManagement.address;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AddressController {
    private AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }


}
