package sadowski.wojciech.myServiceManagement.task.form;

import lombok.Data;
import org.springframework.stereotype.Component;
import sadowski.wojciech.myServiceManagement.address.Address;
import sadowski.wojciech.myServiceManagement.company.Company;
import sadowski.wojciech.myServiceManagement.customer.Customer;
import sadowski.wojciech.myServiceManagement.device.Device;
import sadowski.wojciech.myServiceManagement.task.Task;

@Component
@Data
public class TaskForm {
    private Company company;
    private Customer customer;
    private Address address;
    private Device device;
    private Task task;
}
