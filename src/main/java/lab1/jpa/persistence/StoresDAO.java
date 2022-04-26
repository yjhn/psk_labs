package lab1.jpa.persistence;

import lab1.jpa.entities.Store;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class StoresDAO {
    @Inject
    private EntityManager em;

    @Transactional
    public List<Store> loadAll() {
        return em.createNamedQuery("Store.findAll", Store.class).getResultList();
    }

    public void persist(Store store){
        em.persist(store);
    }

    public Store findById(int id) {
        return em.find(Store.class, id);
    }
}
