package interfaces;
import biens.Chambre;
import reservation.Reservation;
import utilisateurs.Personne;

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
   boolean addChambre(Chambre chambre);
   boolean  addReservation(Reservation reservation );
   boolean  cancelReservation(int id);
   void validReservation(String id);
   void listingLocal();
   boolean removeLocal(String ref);
   Personne searchUtilisateurs(String nci);
   String getRole(String nci);
   int cout(int prix, int taux);
}
