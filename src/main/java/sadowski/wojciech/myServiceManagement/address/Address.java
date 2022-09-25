package sadowski.wojciech.myServiceManagement.address;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Address {
    private Long id;
    private String zipCode;
    private String city;
    private String street;
    private Long[] idDevices;
}
