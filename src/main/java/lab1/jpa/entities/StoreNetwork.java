package lab1.jpa.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "StoreNetwork.findAll", query = "select n from StoreNetwork n")
})
@Getter
@Setter
@Table(name = "store_network")
public class StoreNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "storeNetwork")
    private List<Store> stores;

    @ManyToMany
    private List<City> citiesWithStores = new ArrayList<>();
}
