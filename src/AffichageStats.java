import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by association on 15/12/16.
 */
public class AffichageStats implements Observer, Affichage {
    private List<Float> temperatures;
    private List<Float> humidites;
    private List<Float> pressions;
    private Observable observable;

    public AffichageStats(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);

        temperatures = new ArrayList<>();
        humidites = new ArrayList<>();
        pressions = new ArrayList<>();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof DonneesMeteo) {
            DonneesMeteo donneesMeteo = (DonneesMeteo) o;
            temperatures.add(donneesMeteo.getTemperature());
            humidites.add(donneesMeteo.getHumidite());
            pressions.add(donneesMeteo.getPression());
            afficher();
        }
    }

    @Override
    public void afficher() {
        // TODO : afficher température min/moyenne/max
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
