package sadowski.wojciech.myServiceManagement.interfaces;

import java.util.List;

public interface Repository<T> {
    public void insert(T object);
    public List<T> selectAll();
    public T select(Long id);
    public void put(T object);
    public void delete(Long id);
}
