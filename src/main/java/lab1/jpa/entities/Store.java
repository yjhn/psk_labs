package lab1.jpa.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NamedQueries({
//        @NamedQuery(name = "Store.findAll", query = "select new Store(s.id, c, n) from Store s, City c, StoreNetwork n where s.storeNetwork = n and s.city = c")
        @NamedQuery(name = "Store.findAll", query = "select s from Store s")
})
@Getter
@Setter
@Table
public class Store {
    public Store() {}

    public Store(int id, City city, StoreNetwork storeNetwork) {
        this.id = id;
        this.city = city;
        this.storeNetwork = storeNetwork;
    }

    public Store(int id, int cityId, String cityName, String cityCountryName, int storeNetworkId, String storeNetworkName) {
        this.id = id;
        this.city = new City(cityId, cityName, cityCountryName);
        this.storeNetwork = new StoreNetwork(storeNetworkId, storeNetworkName);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private City city;

    @ManyToOne
    private StoreNetwork storeNetwork;
}
