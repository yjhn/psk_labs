package psk.services;

import javax.enterprise.inject.Specializes;

@Specializes
public class SpecialCityFullNameCreator extends CityFullNameCreator {
    public void createFullCityName(psk.jpa.entities.City city) {
        city.setFullCityName("psk.jpa.entities.City");
    }

    public void createFullCityName(psk.mybatis.model.City city) {
        city.setFullCityName("psk.mybatis.model.City");
    }
}

