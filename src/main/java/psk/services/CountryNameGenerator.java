package psk.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class CountryNameGenerator implements Serializable {
    private final Random rand = new Random();
    private CompletableFuture<String> generationTask = null;

    public void generateNewCountryName() {
        generationTask = CompletableFuture.supplyAsync(() -> generateCountryName());
    }

    private String generateCountryName() {
        try {
            Thread.sleep(5000);
        } catch(Exception ignored) {}
        return "c" + rand.nextInt(1,1000);
    }

    public boolean isNameGenerationRunning() {
        return generationTask != null && !generationTask.isDone();
    }

    public String getCountryNameGenerationStatus() throws ExecutionException, InterruptedException {
        if (generationTask == null) {
            return null;
        } else if (isNameGenerationRunning()) {
            return "country name is being generated...";
        }
        return "country name suggestion: " + generationTask.get();
    }

    public String getResult() throws ExecutionException, InterruptedException {
        return generationTask.get();
    }
}
