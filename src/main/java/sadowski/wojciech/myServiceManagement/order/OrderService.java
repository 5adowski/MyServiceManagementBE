package sadowski.wojciech.myServiceManagement.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements sadowski.wojciech.myServiceManagement.interfaces.Service<Order> {
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Order order) {
        repository.insert(order);
    }

    @Override
    public List<Order> readAll() {
        return repository.selectAll();
    }

    @Override
    public Order read(Long id) {
        return repository.select(id);
    }
}
