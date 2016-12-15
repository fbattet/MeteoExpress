/**
 * Created by association on 15/12/16.
 */
public class AffichageHumidex implements Observateur, Affichage {
    private float humidex;
    private Sujet donneesMeteo;

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

    public AffichageHumidex(Sujet donneesMeteo) {
        donneesMeteo.enregistrerObservateur(this);
        this.donneesMeteo = donneesMeteo;
    }

    @Override
    public void afficher() {
        System.out.println("L'humidex est de " + humidex);
    }

    @Override
    public void actualiser(float temperature, float humidite, float pression) {
        float humidexFahrenheit;
        humidexFahrenheit = computeHeatIndex(temperature*9/5 + 32, humidite);
        humidex = (humidexFahrenheit-32) * 5 / 9;
        afficher();
    }
}
