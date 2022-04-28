package psk.jpa.persistence;

import psk.jpa.entities.City;

import javax.transaction.Transactional;
import java.util.List;

public interface DAO<T> {
    List<T> loadAll();

    @Transactional
    void persist(T entity);

    T findById(int id);
}
