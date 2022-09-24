package sadowski.wojciech.myServiceManagement.technician;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Technician {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
}
