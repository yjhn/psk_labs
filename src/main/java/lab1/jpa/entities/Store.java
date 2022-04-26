package lab1.jpa.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Store.findAll", query = "select s from Store s")
})
@Getter
@Setter
@Table
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private City city;

    @ManyToOne(cascade = CascadeType.MERGE)
    private StoreNetwork storeNetwork;
}
