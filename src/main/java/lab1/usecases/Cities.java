package lab1.usecases;


import lab1.jpa.entities.City;
import lab1.jpa.persistence.CitiesDAO;
import lab1.services.CityValidator;
import lab1.services.NameGenerator;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Cities {
    @Inject
    private CitiesDAO cities;

    @Inject
    private NameGenerator nameGenerator;

    @Inject
    private CityValidator validator;

    @Getter
    @Setter
    private City cityToCreate = new City();

    @Getter
    private List<City> allCities;

    @PostConstruct
    public void init(){
        loadAllCities();
        cityToCreate.setName(nameGenerator.generateCityName());
    }

    public City findById(int id) {
        return cities.findById(id);
    }

    @Transactional
    public void createCity() {
        validator.assignFullCityName(cityToCreate);
            cities.persist(cityToCreate);
    }

    private void loadAllCities(){
        allCities = cities.loadAll();
    }
}
