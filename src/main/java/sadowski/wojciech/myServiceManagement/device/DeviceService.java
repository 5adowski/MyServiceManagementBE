package sadowski.wojciech.myServiceManagement.device;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService implements sadowski.wojciech.myServiceManagement.interfaces.Service<Device> {
    private DeviceRepository repository;

    public DeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Device create(Device device) {
        return repository.insert(device);
    }

    @Override
    public List<Device> readAll() {
        return repository.selectAll();
    }

    @Override
    public Device read(Long id) {
        return repository.select(id);
    }

    @Override
    public void update(Device device) {
        repository.put(device);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
