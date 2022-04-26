package lab1.usecases;


import lab1.jpa.entities.StoreNetwork;
import lab1.jpa.persistence.StoreNetworksDAO;
import lab1.services.NameGenerator;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class StoreNetworksJPA {
    @Inject
    private StoreNetworksDAO networksDAO;

    @Inject
    private NameGenerator nameGenerator;

    @Getter
    @Setter
    private StoreNetwork storeNetworkToCreate = new StoreNetwork();

    @Getter
    private List<StoreNetwork> allStoreNetworks;

    @PostConstruct
    public void init() {
        loadAllNetworks();
        storeNetworkToCreate.setName(nameGenerator.generateStoreNetworkName());
    }

    public StoreNetwork findById(int id) {
        return networksDAO.findById(id);
    }

    @Transactional
    public void createStoreNetwork() {
        networksDAO.persist(storeNetworkToCreate);
    }

    private void loadAllNetworks() {
        allStoreNetworks = networksDAO.loadAll();
    }
}
