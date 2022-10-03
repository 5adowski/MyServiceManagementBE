package sadowski.wojciech.myServiceManagement.address;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements sadowski.wojciech.myServiceManagement.interfaces.Service<Address> {
    private AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address create(Address address) {
        return repository.insert(address);
    }

    @Override
    public List<Address> readAll() {
        return repository.selectAll();
    }

    @Override
    public Address read(Long id) {
        return repository.select(id);
    }

    @Override
    public void update(Address address) {
        repository.put(address);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
