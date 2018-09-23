package cs544.flight.service;

import java.util.List;

public interface IBaseService<T> {
    List<T> findAll();
    T save(T t);
    T findOne(Integer id);
    void delete(Integer id);
}
