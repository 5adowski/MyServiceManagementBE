package sadowski.wojciech.myServiceManagement.task;

import lombok.Data;
import org.springframework.stereotype.Component;
import sadowski.wojciech.myServiceManagement.status.Status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Component
public class Task {
    private Long id;
    private String description;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Status status;
    private String notes;
    private Long idTechnician;
    private Long idCompany;
    private Long idCustomer;
    private Long idAddress;
    private Long idDevice;
}
