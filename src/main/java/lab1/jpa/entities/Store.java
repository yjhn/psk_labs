package lab1.jpa.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object other) {
        if(other == null) {
            return false;
        }
        if(!(other instanceof Store o)) {
            return false;
        }
        return o.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
