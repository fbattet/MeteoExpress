/**
 * Created by association on 15/12/16.
 */
public class AffichagePrevisions implements Observateur, Affichage {
    private float temperature;
    private float humidite;
    private float pression;
    private Sujet donneesMeteo;

    public AffichagePrevisions(Sujet donneesMeteo) {
        this.donneesMeteo = donneesMeteo;
        donneesMeteo.enregistrerObservateur(this);
    }

    @Override
    public void actualiser(float temperature, float humidite, float pression) {
        this.temperature = temperature;
        this.humidite = humidite;
        this.pression = pression;
        afficher();
    }

    @Override
    public void afficher() {
        System.out.println("Il va peut-être faire beau ... ou pas");
    }
}
