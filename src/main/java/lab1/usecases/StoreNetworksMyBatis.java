package lab1.usecases;


import lab1.mybatis.dao.StoreNetworkMapper;
import lab1.mybatis.model.StoreNetwork;
import lab1.services.NameGenerator;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class StoreNetworksMyBatis {
    @Inject
    private StoreNetworkMapper networkMapper;

    @Inject
    private NameGenerator nameGenerator;

    @Getter
    @Setter
    private StoreNetwork storeNetworkToCreate = new StoreNetwork();

    @Getter
    private List<StoreNetwork> allStoreNetworks;

    @PostConstruct
    public void init(){
        loadAllStores();
        storeNetworkToCreate.setName(nameGenerator.generateStoreNetworkName());
    }

    public StoreNetwork findById(int id) {
        return networkMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void createStoreNetwork(){
        networkMapper.insert(storeNetworkToCreate);
    }

    private void loadAllStores(){
        allStoreNetworks = networkMapper.selectAll();
    }
}
