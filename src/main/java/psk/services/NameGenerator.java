package psk.services;

import java.io.Serializable;

public interface NameGenerator extends Serializable {
    String generateStoreNetworkName();

    String generateCityName();
}
