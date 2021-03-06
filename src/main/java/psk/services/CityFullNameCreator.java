package psk.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

/**
 * Component used to create cities' full names.
 */
@ApplicationScoped
public class CityFullNameCreator implements Serializable {
    /**
     * Assigns full city name based on city's name and country's name (JPA version).
     *
     * @param city city to which full names should be assigned
     */
    public void createFullCityName(psk.jpa.entities.City city) {
        if (city == null) {
            throw new NullPointerException("Supplied city is null");
        }
        String cityName = city.getName();
        if (cityName == null) {
            throw new NullPointerException("City's name is null");
        }
        String countryName = city.getCountryName();
        if (countryName == null) {
            throw new NullPointerException("Country's name is null");
        }

        city.setFullCityName(generateName(countryName, cityName));
    }

    /**
     * Assigns full city name based on city's name and country's name (MyBatis version).
     *
     * @param city city to which full names should be assigned
     */
    public void createFullCityName(psk.mybatis.model.City city) {
        if (city == null) {
            throw new NullPointerException("Supplied city is null");
        }
        String cityName = city.getName();
        if (cityName == null) {
            throw new NullPointerException("City's name is null");
        }
        String countryName = city.getCountryName1();
        if (countryName == null) {
            throw new NullPointerException("Country's name is null");
        }

        city.setFullCityName(generateName(countryName, cityName));
    }

    private String generateName(String countryName, String cityName) {
        return "\"" + countryName + "\".\"" + cityName + "\"";
    }
}
