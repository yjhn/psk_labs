package lab1.jpa.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne
    private StoreNetwork storeNetwork;
}
