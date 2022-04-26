package psk.usecases;


import psk.mybatis.dao.CityMapper;
import psk.mybatis.model.City;
import psk.services.CityFullNameCreator;
import psk.services.NameGenerator;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class CitiesMyBatis {
    @Inject
    private CityMapper cityMapper;

    @Inject
    private NameGenerator nameGenerator;

    @Inject
    private CityFullNameCreator validator;

    @Getter
    @Setter
    private City cityToCreate = new City();

    @Getter
    private List<City> allCities;

    @PostConstruct
    public void init() {
        loadAllCities();
        cityToCreate.setName(nameGenerator.generateCityName());
    }

    public City findById(int id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void createCity() {
        validator.createFullCityName(cityToCreate);
        cityMapper.insert(cityToCreate);
    }

    private void loadAllCities() {
        allCities = cityMapper.selectAll();
    }
}
