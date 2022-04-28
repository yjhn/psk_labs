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

    @Transactional
    public void persist(City c) {
        em.persist(c);
        em.flush();
    }

    public City findById(int id) {
        return em.find(City.class, id);
    }
}
