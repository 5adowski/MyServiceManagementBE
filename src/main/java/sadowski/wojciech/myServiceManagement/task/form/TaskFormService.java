package sadowski.wojciech.myServiceManagement.task.form;

import org.springframework.stereotype.Service;
import sadowski.wojciech.myServiceManagement.address.Address;
import sadowski.wojciech.myServiceManagement.address.AddressService;
import sadowski.wojciech.myServiceManagement.company.Company;
import sadowski.wojciech.myServiceManagement.company.CompanyService;
import sadowski.wojciech.myServiceManagement.customer.Customer;
import sadowski.wojciech.myServiceManagement.customer.CustomerService;
import sadowski.wojciech.myServiceManagement.device.Device;
import sadowski.wojciech.myServiceManagement.device.DeviceService;
import sadowski.wojciech.myServiceManagement.task.Task;
import sadowski.wojciech.myServiceManagement.task.TaskService;

import java.util.ArrayList;
import java.util.List;


@Service
public class TaskFormService {
    private CompanyService companyService;
    private CustomerService customerService;
    private AddressService addressService;
    private DeviceService deviceService;
    private TaskService taskService;

    public TaskFormService(CompanyService companyService, CustomerService customerService, AddressService addressService, DeviceService deviceService, TaskService taskService) {
        this.companyService = companyService;
        this.customerService = customerService;
        this.addressService = addressService;
        this.deviceService = deviceService;
        this.taskService = taskService;
    }

    public TaskForm create(TaskForm taskForm) {
        Company company = companyService.create(taskForm.getCompany());

        Address address = addressService.create(taskForm.getAddress());

        Customer customer = taskForm.getCustomer();
        customer.setTin(company.getTin());
        Long[] ids = customer.getIdAddresses();
        ArrayList<Long> list = new ArrayList<>(List.of(ids));
        list.add(address.getId());
        customer.setIdAddresses(list.toArray(new Long[0]));
        customerService.create(customer);

        Device device = taskForm.getDevice();
        device.setIdAddress(address.getId());
        deviceService.create(device);

        Task task = taskForm.getTask();
        task.setIdCompany(company.getTin());
        task.setIdCustomer(customer.getId());
        task.setIdAddress(customer.getId());
        task.setIdDevice(device.getId());
        taskService.create(task);

        taskForm.setCompany(company);
        taskForm.setAddress(address);
        taskForm.setCustomer(customer);
        taskForm.setDevice(device);
        taskForm.setTask(task);
        return taskForm;
    }
}
