package lab1.jpa.persistence;

import lab1.jpa.entities.StoreNetwork;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class StoreNetworksDAO {
    @Inject
    private EntityManager em;

    public List<StoreNetwork> loadAll() {
        return em.createNamedQuery("StoreNetwork.findAll", StoreNetwork.class).getResultList();
    }

    public void persist(StoreNetwork storeNetwork) {
        em.persist(storeNetwork);
    }

    public void update(StoreNetwork storeNetwork) {
        em.merge(storeNetwork);
    }

    public StoreNetwork findById(int id) {
        return em.find(StoreNetwork.class, id);
    }
}
