import java.util.Observable;
import java.util.Observer;

/**
 * Created by association on 15/12/16.
 */
public class AffichagePrevisions implements Observer, Affichage {
    private float temperature;
    private float humidite;
    private float pression;
    private Observable observable;

    public AffichagePrevisions(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof DonneesMeteo) {
            DonneesMeteo donneesMeteo = (DonneesMeteo) o;
            this.temperature = donneesMeteo.getTemperature();
            this.humidite = donneesMeteo.getHumidite();
            this.pression = donneesMeteo.getPression();
            afficher();
        }
    }

    @Override
    public void afficher() {
        // TODO : Afficher la tendance (à la hausse, à la baisse)
        System.out.println("Il va peut-être faire beau ... ou pas");
    }
}
