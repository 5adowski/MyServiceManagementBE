package sadowski.wojciech.myServiceManagement.device;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Device {
    private Long id;
    private String idFactory;
    private String idFd;
    private String serialNumber;
    private String catalogNumber;
    private Long idAddress;
}
