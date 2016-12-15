/**
 * Created by association on 15/12/16.
 */
public class StationMeteo {

    public static void main(String[] args) {

        DonneesMeteo donneesMeteo = new DonneesMeteo();

        AffichageConditions affichageConditions = new AffichageConditions(donneesMeteo);
        AffichagePrevisions affichagePrevisions = new AffichagePrevisions(donneesMeteo);
        AffichageStats affichageStats = new AffichageStats(donneesMeteo);
        AffichageHumidex affichageHumidex = new AffichageHumidex(donneesMeteo);


        donneesMeteo.setMesures(26,65,1020);
        donneesMeteo.setMesures(28,70,1012);
        donneesMeteo.setMesures(22,90,1012);
    }
}
