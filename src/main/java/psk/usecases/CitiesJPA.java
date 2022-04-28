package psk.usecases;


import psk.jpa.entities.City;
import psk.jpa.persistence.CitiesDAO;
import psk.services.CityFullNameCreator;
import psk.services.CountryNameGenerator;
import psk.services.NameGenerator;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.util.List;

import static java.lang.System.out;
import java.lang.Thread;
import java.util.concurrent.ExecutionException;

@Model
@LogMethodInvocations
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
    @Setter
    private City cityToEdit;

    public void saveCityChanges() throws InterruptedException {
        fullNameCreator.createFullCityName(cityToEdit);
        out.println("sleeping for 5 seconds");
        Thread.sleep(5000);
        try {
            saveCityChangesInternal(cityToEdit);
        } catch (OptimisticLockException e) {
            out.println("Caught optimistic lock exception:\n" + e);
            out.println("Retrying up to 3 times");
            for(int i = 0; i < 3; ++i) {
                City c = cities.findById(cityToEdit.getId());
                c.setFullCityName(cityToEdit.getFullCityName());
                c.setName(cityToEdit.getName());
                c.setCountryName(cityToEdit.getCountryName());
                out.println("Overwriting previous changes");
                try {
                    saveCityChangesInternal(c);
                    break;
                } catch (OptimisticLockException exc) {
                    out.println("Caught optimistic lock exception:\n" + exc);
                }
            }
        }
    }

    @Transactional
    public void saveCityChangesInternal(City c) {
        cities.persist(c);
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
