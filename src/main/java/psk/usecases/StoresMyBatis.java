package psk.usecases;


import psk.mybatis.dao.CityMapper;
import psk.mybatis.dao.StoreMapper;
import psk.mybatis.dao.StoreNetworkMapper;
import psk.mybatis.model.Store;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class StoresMyBatis {
    @Inject
    private StoreMapper storeMapper;

    @Inject
    private CityMapper cityMapper;

    @Inject
    private StoreNetworkMapper storeNetworkMapper;

    @Getter
    @Setter
    private Store storeToCreate = new Store();

    @Getter
    private List<Store> allStores;

    @PostConstruct
    public void init() {
        loadAllStores();
    }

    public Store findById(int id) {
        return storeMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void createStore() {
//        System.out.println(storeNetworkMapper.selectCitiesWithStores(storeToCreate.getStoreNetworkId()).size());
//        System.out.println(cityMapper.selectStoreNetworksInCity(storeToCreate.getCityId()).size());
        storeMapper.insert(storeToCreate);
    }

    private void loadAllStores() {
        allStores = storeMapper.selectAll();
    }
}
