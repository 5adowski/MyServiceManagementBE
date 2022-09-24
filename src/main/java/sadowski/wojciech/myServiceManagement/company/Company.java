package sadowski.wojciech.myServiceManagement.company;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Company {
    private Long TIN;
    private String name;
    private String zipCode;
    private String city;
    private String street;
}
