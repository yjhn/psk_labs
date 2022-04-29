package psk.rest.contracts;

import lombok.Getter;
import lombok.Setter;
import psk.jpa.entities.City;
import psk.jpa.entities.StoreNetwork;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StoreDTO {
    private int id;
    @NotNull
    private String addressInCity;
    private int cityId;
    private String cityName;
    private String cityCountryName;
    private String cityFullName;
    private int storeNetworkId;
    private String storeNetworkName;
}
