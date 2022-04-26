package lab1.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class NameGenerator implements Serializable {
    private final Random rand = new Random();

    public String storeNetworkNameGenerator() {
        int random = rand.nextInt(100);
        String name = random > 50 ? "Big store network " : "Small store network ";
        return name + rand.nextInt();
    }

    public String cityNameGenerator() {
        int random = rand.nextInt(100);
        String name;
        if(random < 21) {
            name = "Tiny town ";
        } else if(random < 41) {
            name = "Small town ";
        } else if(random < 61) {
            name = "Big town ";
        } else if(random < 81) {
            name = "Small city ";
        } else {
            name = "Big city ";
        }
        return name + rand.nextInt();
    }
}
