package psk.jpa.persistence;

import psk.jpa.entities.City;
import psk.jpa.entities.StoreNetwork;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class StoreNetworksDAO implements DAO<StoreNetwork> {
    @Inject
    private EntityManager em;

    public List<StoreNetwork> loadAll() {
        return em.createNamedQuery("StoreNetwork.findAll", StoreNetwork.class).getResultList();
    }

    public void persist(StoreNetwork storeNetwork) {
        em.persist(storeNetwork);
    }

    public StoreNetwork update(StoreNetwork storeNetwork) {
        return em.merge(storeNetwork);
    }

    public StoreNetwork findById(int id) {
        return em.find(StoreNetwork.class, id);
    }
}
