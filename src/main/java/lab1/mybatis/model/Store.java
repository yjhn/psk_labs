package lab1.mybatis.model;

public class Store {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STORE.ID
     *
     * @mbg.generated Fri Mar 04 14:14:56 EET 2022
     */
    private Integer id;

    private String addressInCity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STORE.CITY_ID
     *
     * @mbg.generated Fri Mar 04 14:14:56 EET 2022
     */
    private Integer cityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STORE.STORENETWORK_ID
     *
     * @mbg.generated Fri Mar 04 14:14:56 EET 2022
     */
    private Integer storeNetworkId;

    private City city;
    private StoreNetwork storeNetwork;

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public StoreNetwork getStoreNetwork() {
        return this.storeNetwork;
    }

    public void setStoreNetwork(StoreNetwork storeNetwork) {
        this.storeNetwork = storeNetwork;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STORE.ID
     *
     * @return the value of PUBLIC.STORE.ID
     * @mbg.generated Fri Mar 04 14:14:56 EET 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STORE.ID
     *
     * @param id the value for PUBLIC.STORE.ID
     * @mbg.generated Fri Mar 04 14:14:56 EET 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STORE.CITY_ID
     *
     * @return the value of PUBLIC.STORE.CITY_ID
     * @mbg.generated Fri Mar 04 14:14:56 EET 2022
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STORE.CITY_ID
     *
     * @param cityId the value for PUBLIC.STORE.CITY_ID
     * @mbg.generated Fri Mar 04 14:14:56 EET 2022
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STORE.STORENETWORK_ID
     *
     * @return the value of PUBLIC.STORE.STORENETWORK_ID
     * @mbg.generated Fri Mar 04 14:14:56 EET 2022
     */
    public Integer getStoreNetworkId() {
        return storeNetworkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STORE.STORENETWORK_ID
     *
     * @param storeNetworkId the value for PUBLIC.STORE.STORENETWORK_ID
     * @mbg.generated Fri Mar 04 14:14:56 EET 2022
     */
    public void setStoreNetworkId(Integer storeNetworkId) {
        this.storeNetworkId = storeNetworkId;
    }

    public String getAddressInCity() {
        return addressInCity;
    }

    public void setAddressInCity(String addressInCity) {
        this.addressInCity = addressInCity;
    }
}