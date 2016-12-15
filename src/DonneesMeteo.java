import java.util.ArrayList;
import java.util.List;

/**
 * Created by association on 15/12/16.
 */
public class DonneesMeteo implements Sujet {
//    private List<Observateur> observateurs;
    private ArrayList observateurs;

    private float temperature;
    private float humidite;
    private float pression;

    public DonneesMeteo() {
//        observateurs = new ArrayList<>();
        observateurs = new ArrayList();
    }

    @Override
    public void enregistrerObservateur(Observateur observateur) {
        observateurs.add(observateur);
    }

    @Override
    public void supprimerObservateur(Observateur observateur) {
//        observateurs.remove(observateur);
        int i = observateurs.indexOf(observateur);
        if (i >= 0) {
            observateurs.remove(i);
        }
    }

    @Override
    public void notifierObservateurs() {
        for (int i = 0; i < observateurs.size(); i++) {
            Observateur observateur = (Observateur) observateurs.get(i);
            observateur.actualiser(temperature, humidite, pression);
        }
//        for(Observateur affichage : observateurs) {
//            affichage.actualiser(temp, humidite, pression);
    }

    public void actualiserMesures() {
        notifierObservateurs();
    }

    public void setMesures(float temperature, float humidite, float pression) {
        this.temperature = temperature;
        this.humidite = humidite;
        this.pression = pression;
        actualiserMesures();
    }

    public float getTemperature() {
        return 0f;
    }

    public float getHumidite() {
        return 0f;
    }

    public float getPression() {
        return 0f;
    }

}
