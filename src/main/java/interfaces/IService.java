package interfaces;
import biens.Appartement;
import biens.Chambre;
import biens.Local;
import org.json.simple.JSONArray;
import reservation.Reservation;
import utilisateurs.Personne;

import java.util.ArrayList;

/**
 * ***************** Fonctionnalites du Gestionnaires ******
 *  1- Gerer les local (Ajouts, Modifier, Supprimer)
 *  2- Gerer Rèservation(Valider, Annuler)
 *  3- Gerer compte clients(Supprimer, Voir infos)
 //////////////////////////////////////////////////////////
 * ***************** Fonctionnalites du clients       ******
 *  1- S'inscrire
 *  2- Faire reservation
 //////////////////////////////////////////////////////////
 *********************** Fonctionnalités Communs********************
 *  1- Se connecter
 *  2- Lister locaux
 *  3- Annuler réservation
 */
public interface IService{
   boolean addUtilisateur(Personne Personne);
   boolean removePersonneClient(Personne personne);
   boolean loginToApp(String login, String password);
   void addChambre(Chambre chambre);
   void addLocalAppart(Appartement appartement);
   void addReservation(Reservation reservation );
   void listReservationsEnCours();
   void validReservation(String id);
   void listingLocal();
   void seeReservationByclient(String clientNci);
   Personne searchUtilisateurs(String nci);
   String getRole(String nci);
   int cout(int prix, int taux);

   ArrayList<Personne> convertisseursJsonArrayPersonne();

   ArrayList<Local> convertisseursJsonArrayLocal();

   ArrayList<Chambre> convertisseursJsonArrayChambre();

   void writeJsonArray(JSONArray jsonArray, String path);

   JSONArray jsonFile(String path);

   void flushEcran();

   void pauseEcran();

   ArrayList<Reservation> convertisseursJsonArrayReservation();
}
