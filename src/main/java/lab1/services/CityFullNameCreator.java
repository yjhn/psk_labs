package lab1.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CityFullNameCreator {
    public void assignFullCityName(lab1.jpa.entities.City city) {
        city.setFullCityName("\"" + city.getCountryName() + "\".\"" + city.getName() + "\"");
    }

    public void assignFullCityName(lab1.mybatis.model.City city) {
        city.setFullCityName("\"" + city.getCountryName() + "\".\"" + city.getName() + "\"");
    }
}
