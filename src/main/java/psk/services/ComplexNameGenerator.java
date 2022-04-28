package psk.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.Random;

@Alternative
@ApplicationScoped
public class ComplexNameGenerator implements NameGenerator {
    private final Random rand = new Random();

    @Override
    public String generateStoreNetworkName() {
        int random = rand.nextInt(100);
        String name = random >= 50 ? "Big store network " : "Small store network ";
        return name + rand.nextInt(1000);
    }

    @Override
    public String generateCityName() {
        int random = rand.nextInt(100);
        String name;
        if (random < 20) {
            name = "Tiny town ";
        } else if (random < 40) {
            name = "Small town ";
        } else if (random < 60) {
            name = "Big town ";
        } else if (random < 80) {
            name = "Small city ";
        } else {
            name = "Big city ";
        }
        return name + rand.nextInt(100000000);
    }
}
