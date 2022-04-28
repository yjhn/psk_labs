package psk.usecases;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.transaction.Transactional;
import static java.lang.System.out;

import psk.jpa.persistence.DAO;

import java.util.List;

@Decorator
public class LogInterfaceMethodInvocations<T>
        implements DAO<T> {
    @Inject
    @Delegate
    @Any
    DAO<T> dao;

    public List<T> loadAll() {
        List<T> result = dao.loadAll();
        out.println("Method 'loadAll' from DAO interface called, returned list with size " + result.size());
        return result;
    }

    @Transactional
    public void persist(T entity) {
        dao.persist(entity);
        out.println("Method 'persist' from DAO interface called with entity of type " + entity.getClass().getName());
    }

    public T findById(int id) {
        T result = dao.findById(id);
        out.println("Method 'findById' from DAO interface called, returned entity of type " + result.getClass().getName());
        return result;
    }
}