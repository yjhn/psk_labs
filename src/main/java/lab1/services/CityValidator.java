package lab1.services;

import lab1.jpa.entities.City;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

@ApplicationScoped
public class CityValidator {
    public void assignFullCityName(City city) {
        city.setFullCityName("\"" + city.getCountryName() + "\".\"" + city.getName() + "\"");
    }
}
