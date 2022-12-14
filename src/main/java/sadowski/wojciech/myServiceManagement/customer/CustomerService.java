package sadowski.wojciech.myServiceManagement.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements sadowski.wojciech.myServiceManagement.interfaces.Service<Customer> {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(Customer customer) {
        return repository.insert(customer);
    }

    @Override
    public List<Customer> readAll() {
        return repository.selectAll();
    }

    @Override
    public Customer read(Long id) {
        return repository.select(id);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.put(customer);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

}
