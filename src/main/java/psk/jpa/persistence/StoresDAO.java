package psk.jpa.persistence;

import psk.jpa.entities.Store;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class StoresDAO implements DAO<Store> {
    @Inject
    private EntityManager em;

    public List<Store> loadAll() {
        return em.createNamedQuery("Store.findAll", Store.class).getResultList();
    }

    @Transactional
    public void persist(Store store) {
        em.persist(store);
    }

    public Store findById(int id) {
        return em.find(Store.class, id);
    }
}
