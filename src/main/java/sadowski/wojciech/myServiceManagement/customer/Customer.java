package sadowski.wojciech.myServiceManagement.customer;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Long tin;
    private Long[] idAddresses;
}
