package psk.usecases;


import psk.jpa.entities.City;
import psk.jpa.persistence.CitiesDAO;
import psk.services.CityFullNameCreator;
import psk.services.NameGenerator;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.util.List;

import static java.lang.System.out;
import static java.lang.Thread.sleep;

@Model
public class CitiesJPA {
    @Inject
    private CitiesDAO cities;

    @Inject
    private NameGenerator nameGenerator;

    @Inject
    private CityFullNameCreator fullNameCreator;

    @Getter
    @Setter
    private City cityToCreate = new City();

    @Getter
    private City cityToEdit;

    public void setCityToEdit(City city) {
        fullNameCreator.createFullCityName(city);
        cityToEdit.setFullCityName(city.getFullCityName());
        cityToEdit.setName(city.getName());
        cityToEdit.setCountryName(city.getCountryName());
    }

    public void saveCityChanges() throws InterruptedException {
        try {
            saveCityChangesInternal();
        } catch (OptimisticLockException e) {
            out.println("Caught optimistic lock exception:\n" + e);
            saveCityChangesInternal();
        }
        out.println("saveCityChanges() called, sleeping for 5 seconds");
        sleep(5000);
    }

    @Transactional
    public void saveCityChangesInternal() {
        cities.persist(cityToEdit);
    }

    @Getter
    private List<City> allCities;

    @PostConstruct
    public void init() {
        loadAllCities();
        cityToCreate.setName(nameGenerator.generateCityName());
    }

    public City findById(int id) {
        return cities.findById(id);
    }

    @Transactional
    public void createCity() {
        fullNameCreator.createFullCityName(cityToCreate);
        cities.persist(cityToCreate);
    }

    private void loadAllCities() {
        allCities = cities.loadAll();
        if (allCities.size() >= 1) {
            cityToEdit = allCities.get(0);
        }
    }
}
