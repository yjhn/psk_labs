package lab1.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class NameGenerator implements Serializable {
    private final Random rand = new Random();

    public String generateStoreNetworkName() {
        int random = rand.nextInt(100);
        String name = random >= 50 ? "Big store network " : "Small store network ";
        return name + rand.nextInt(1000);
    }

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
