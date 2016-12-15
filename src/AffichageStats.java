import java.util.ArrayList;
import java.util.List;

/**
 * Created by association on 15/12/16.
 */
public class AffichageStats implements Observateur, Affichage {
    private List<Float> temperatures;
    private List<Float> humidites;
    private List<Float> pressions;
    private Sujet donneesMeteo;

    public AffichageStats(Sujet donneesMeteo) {
        this.donneesMeteo = donneesMeteo;
        donneesMeteo.enregistrerObservateur(this);

        temperatures = new ArrayList<>();
        humidites = new ArrayList<>();
        pressions = new ArrayList<>();
    }

    @Override
    public void actualiser(float temperature, float humidite, float pression) {
        temperatures.add(temperature);
        humidites.add(humidite);
        pressions.add(pression);
        afficher();
    }

    @Override
    public void afficher() {
        System.out.print("Températures : ");
        for (float temperature :
                temperatures) {
            System.out.print(temperature + " ");
        }

        System.out.print("\nHumidités : ");
        for (float humidite :
                humidites) {
            System.out.print(humidite + " ");
        }

        System.out.print("\nPression : ");
        for (float pression :
               pressions ) {
            System.out.print(pression + " ");
        }
        System.out.println();
    }
}
