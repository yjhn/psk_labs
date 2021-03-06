package psk.jpa.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "storeNetwork")
    private List<Store> stores;

    @ManyToMany
    private Set<City> citiesWithStores = new HashSet<>();

    @Version
    @Column(name = "opt_lock_version")
    private int optLockVersion;

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof StoreNetwork o)) {
            return false;
        }
        return o.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
