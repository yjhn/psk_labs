package psk.jpa.persistence;

import psk.jpa.entities.City;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CitiesDAO {
    @Inject
    private EntityManager em;

    public List<City> loadAll() {
        return em.createNamedQuery("City.findAll", City.class).getResultList();
    }

    public void persist(City city) {
        em.persist(city);
    }

    public City findById(int id) {
        return em.find(City.class, id);
    }
}
