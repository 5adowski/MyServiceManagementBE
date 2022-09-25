package sadowski.wojciech.myServiceManagement.interfaces;

import java.util.List;

public interface Service<T> {
    public void create(T object);
    public List<T> readAll();
    public T read(Long id);
    public void update(T object);
    public void delete(Long id);
}
