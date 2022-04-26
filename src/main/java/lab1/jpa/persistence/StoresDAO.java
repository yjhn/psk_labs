package lab1.jpa.persistence;

import lab1.jpa.entities.City;
import lab1.jpa.entities.Store;
import lab1.jpa.entities.StoreNetwork;

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
//        City c = new City();
//        c.setName("City 1");
//        c.setCountryName("Country 1");
//        StoreNetwork n1 = new StoreNetwork();
//        n1.setName("Store network 1");
//        Store s1 = new Store();
//        Store s2 = new Store();
//        s1.setCity(c); // TODO: too much shit, don't have to do this, can just create StoreNetwork or City
//        s2.setCity(c);
//        s1.setStoreNetwork(n1);
//        s2.setStoreNetwork(n1);
//        em.persist(c);
//        em.persist(n1);
//        em.persist(s1);
//        em.persist(s2);
//        em.flush();
        List<Store> stores = em.createNamedQuery("Store.findAll", Store.class).getResultList();
        return stores;
    }

//    @Transactional
    public void persist(Store store){
        em.persist(store);
    }

    public Store findById(int id) {
        return em.find(Store.class, id);
    }
}
