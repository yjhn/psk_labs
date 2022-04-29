package psk.jpa.persistence;

import psk.jpa.entities.City;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class CitiesDAO implements DAO<City> {
    @Inject
    private EntityManager em;

    public List<City> loadAll() {
        return em.createNamedQuery("City.findAll", City.class).getResultList();
    }

    public void persist(City c) {
        em.persist(c);
        em.flush();
    }

    @Transactional
    public City update(City c) {
        City r = em.merge(c);
        em.flush();
        return r;
    }

    public City findById(int id) {
        return em.find(City.class, id);
    }
}
