package lab1.usecases;


import lab1.jpa.entities.City;
import lab1.jpa.entities.Store;
import lab1.jpa.entities.StoreNetwork;
import lab1.jpa.persistence.StoresDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class StoresJPA {
    @Inject
    private StoresDAO stores;

    @Getter
    @Setter
    private Store storeToCreate = new Store();

    @Getter
    private List<Store> allStores;

    @PostConstruct
    public void init(){
        loadAllStores();
        storeToCreate.setStoreNetwork(new StoreNetwork());
        storeToCreate.setCity(new City());
    }

    public Store findById(int id) {
        return stores.findById(id);
    }

    @Transactional
    public void createStore(){
        stores.persist(storeToCreate);
    }

    private void loadAllStores(){
        allStores = stores.loadAll();
    }
}
