package lab1.jpa.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "StoreNetwork.findAll", query = "select n from StoreNetwork n")
})
@Getter
@Setter
@Table(name = "STORE_NETWORK")
public class StoreNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "storeNetwork")
    private List<Store> stores;

    @ManyToMany
    private List<City> citiesWithStores;
}
