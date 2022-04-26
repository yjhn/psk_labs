package lab1.usecases;


import lab1.mybatis.dao.StoreMapper;
import lab1.mybatis.model.Store;
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

    @Getter
    @Setter
    private Store storeToCreate = new Store();

    @Getter
    private List<Store> allStores;

    @PostConstruct
    public void init(){
        loadAllStores();
    }

    public Store findById(int id) {
        return storeMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void createStore(){
        storeMapper.insert(storeToCreate);
    }

    private void loadAllStores(){
        allStores = storeMapper.selectAll();
    }
}
