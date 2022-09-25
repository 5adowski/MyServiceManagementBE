package sadowski.wojciech.myServiceManagement.order;

import lombok.Data;
import org.springframework.stereotype.Component;
import sadowski.wojciech.myServiceManagement.status.Status;

@Data
@Component
public class Order {
    private Long id;
    private Status status;
    private Long idTechnician;
    private Long idCompany;
    private Long idCustomer;
    private Long idAddress;
    private Long idDevice;
}
