package cs544.flight.service;

import java.util.List;

public interface IBaseService<T> {
    List<T> findAll();
    T save(T t);
    T findOne(Long id);
    void delete(Long id);
}
