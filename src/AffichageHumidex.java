import java.util.Observable;
import java.util.Observer;

/**
 * Created by association on 15/12/16.
 */
public class AffichageHumidex implements Observer, Affichage {
    private float humidex;
    private Observable observable;

    private float computeHeatIndex(float t, float rh) {
        float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
                (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
                (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh)));
        return index;
    }

    public AffichageHumidex(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof DonneesMeteo) {
            DonneesMeteo donneesMeteo = (DonneesMeteo) o;
            float humidexFahrenheit;
            humidexFahrenheit = computeHeatIndex(donneesMeteo.getTemperature()*9/5 + 32, donneesMeteo.getHumidite());
            humidex = (humidexFahrenheit-32) * 5 / 9;
            afficher();
        }
    }

    @Override
    public void afficher() {
        System.out.println("L'humidex est de " + humidex);
    }

}
