package psk.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
public class SimpleNameGenerator implements NameGenerator {
    @Override
    public String generateStoreNetworkName() {
        return "store network";
    }

    @Override
    public String generateCityName() {
        return "city";
    }
}
