package psk.jpa.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @Column(name = "full_city_name", nullable = false)
    private String fullCityName;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @OneToMany(mappedBy = "city")
    private List<Store> stores;

    @ManyToMany(mappedBy = "citiesWithStores")
    private Set<StoreNetwork> storeNetworks;

    @Version
    private int optLockVersion;

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof City o)) {
            return false;
        }
        return o.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
