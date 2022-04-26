package lab1.services;

import lab1.jpa.entities.City;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CityValidator {
    public boolean isValidCity(City city) {
        String name = city.getName();
        String countryName = city.getCountryName();
        return !(name.isEmpty() || name.isBlank() || countryName.isEmpty() || countryName.isBlank());
    }
}
