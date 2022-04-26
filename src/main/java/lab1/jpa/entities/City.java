package lab1.jpa.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "City.findAll", query = "select c from City c")
})
@Table
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "country_name")
    private String countryName;

    @OneToMany(mappedBy = "city")
    private List<Store> stores;

    @ManyToMany(mappedBy = "citiesWithStores")
    private List<StoreNetwork> storeNetworks;
}
