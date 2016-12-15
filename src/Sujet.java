/**
 * Created by association on 15/12/16.
 */
public interface Sujet {
    public void enregistrerObservateur(Observateur affichage);
    public void supprimerObservateur(Observateur affichage);
    public void notifierObservateurs();

}
