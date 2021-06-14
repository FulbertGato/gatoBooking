import biens.Appartement;
import biens.Chambre;
import formulaires.LocalForms;
import formulaires.PersonneForms;
import formulaires.ReservationForm;
import services.Service;
import utilisateurs.Personne;
import validator.Validation;
import reservation.Reservation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class App {

        public static Scanner scanner = new Scanner(System.in);
        public static Service service = new Service();
        public static Validation validation = new Validation();
        static PersonneForms formulaire = new PersonneForms();
        static LocalForms formulairelOc = new LocalForms();
        static ReservationForm formulaireRes = new ReservationForm();
        static int  choix;
        static ArrayList<Chambre> listeChambre = new ArrayList<Chambre> ();
       // Chambre chambre = new Chambre( "Paris",500,200,"disponible",200);
      //  listeChambre.add(chambre);
        static Map<String, String> user;
        static Map<String, String> reservation;
        public static void main( String[] args )
        {
            service.flushEcran();

            do{
                
                choix = menuVisiteur();
                switch(choix){
                    case 1:
                        service.flushEcran();
                        service.listingLocal();
                        service.flushEcran();
                        service.listingLocal();
                        service.pauseEcran();
                        service.flushEcran();
                        break;
                    case 2:
                        user = formulaire.registerForm();
                        if(user==null){
                           
                            choix =6;

                        }else{
                       
                        Personne personne = new Personne(user.get("nci"),user.get("nomComplet"),user.get("telephone"),user.get("adresse"),user.get("email"),user.get("motDePasse"),"CLIENT");
                        
                        if(service.addUtilisateur(personne) || service.loginToApp(user.get("nci"), user.get("motDePasse"))){

                            do{
                                choix=menuClient();

                                switch (choix) {
                                    case 1:

                                    

                                        break;
                                    case 2:

                                        break;
                                    case 3:

                                        break;
                                    case 4:

                                        break;
                                    case 5:
                                        service.flushEcran();
                                        System.out.println("\n");
                                        System.out.println(" Hey A la prochaine ❤️🥵 ");
                                        System.out.println("\n");

                                        break;
                                    default:
                                        break;
                                }
                            }while(choix!=5 );
                        }
                    }
                        break;
                    case 3:
                        user=formulaire.loginForm();
                        if(service.loginToApp(user.get("nci"), user.get("motDePasse")) && service.getRole(user.get("nci")).equals("CLIENT")){
                            //connecter en tant que client
                            do{
                                choix=menuClient();

                                switch (choix) {
                                    case 1:
                                        service.seeReservationByclient(user.get("nci"));
                                        service.pauseEcran();
                                        break;
                                    case 2:
                                        service.listingLocal();
                                        break;
                                    case 3:
                                        service.listingLocal();
                                       reservation = formulaireRes.doReservationForm();
                                       Reservation res = new Reservation(user.get("nci"),reservation.get("ref"),reservation.get("dure"),"EN COURS",5000);
                                       service.addReservation(res);
                                        break;
                                    case 4:
                                          Personne client=service.searchUtilisateurs(user.get("nci"));
                                          System.out.println(client.affichage());
                                          service.pauseEcran();

                                        break;
                                    case 5:
                                        service.flushEcran();
                                        System.out.println("\n");
                                        System.out.println(" Hey A la prochaine ❤️🥵 ");
                                        System.out.println("\n");


                                        break;
                                    default:
                                        break;
                                }
                            }while(choix!=5 );
                        }

                        else if(service.loginToApp(user.get("nci"), user.get("motDePasse")) && service.getRole(user.get("nci")).equals("GESTIONNAIRE")){
                            //connecter en tant que gestionnaire
                            do{
                                choix=menuGestionnaire();
                                
                                switch (choix) {
                                    
                                    case 1:

                                        break;
                                    case 2:
                                       service.validReservation(formulaireRes.validateReservationForm().get("ref"));
                                        break;
                                    case 3:
                                         
                                         choix = menuGestionLocaux();
                                         //Demande de la page de Gestion de Locaux
                                         
                                         switch (choix) {
                                            case 1:
                                                // demande l'interface voir les reservation
                                                 /* service.flushEcran();
                                                  service.listReservationsEnCours();
                                                  service.flushEcran();*/
                                                  service.listReservationsEnCours();
                                                 // service.flushEcran();
                                                  service.pauseEcran();
                                                  choix = 3;
                                                  
                                                  break;
                                            case 2:
                                                  System.out.print("\n\t\t\t ");
                                                   
                                                 break;
                                            case 3:
                                                break;
                                            case 4:
                                                
                                                //Demande du local a ajout local
                                                service.flushEcran();
                                                System.out.print("\n\t\t\t🏠🏠🏠🏠🏡🏘️ QUEL TYPE DE LOCAL VOUS VOULEZ ? 🏠🏠🏠🏡🏘️🏗️🏭🏢🏬🏠🏠");
                                                System.out.print("\n\t\t\t|                       1-Appartements (3 piece minimum)      |");
                                                System.out.print("\n\t\t\t|                       2- Chambre                            |");
                                                System.out.print("\n\t\t\t|                       3-annuler                            |");
                                                System.out.print("\n\t\t\t---------------------------------------------------------------");
                                                //System.out.print("\n\t\t\tFaites votre choix entre 1 ou 2 : ");
                                                String type;
                                                do{
                                                System.out.print("\n\t\t\tFaites votre choix entre 1 ou 2 : ");
                                                type = scanner.nextLine();
                                                }while (! Validation.isInt(type) && Integer.parseInt(type) != 3 && Integer.parseInt(type) != 2 && Integer.parseInt(type) != 1 );
                                                if(Integer.parseInt(type)  == 2)  {

                                                    Map<String, String> localAdd=formulairelOc.addChambre();

                                                    Chambre chambre = new Chambre(localAdd.get("localisation"),Integer.parseInt(localAdd.get("prix")),Integer.parseInt(localAdd.get("taux")),localAdd.get("etat"),Integer.parseInt(localAdd.get("dimension")));
                                                    service.addChambre(chambre);
                                                }else if(Integer.parseInt(type)  == 1){
                                                    Map<String, String> appAdd= formulairelOc.addAppartements();
                                                    for(int i=1; i< Integer.parseInt(appAdd.get("nombrePiece"));i++){

                                                        System.out.println("Entrez la dimension ");
                                                        int dimension = Integer.parseInt(scanner.nextLine());

                                                        Chambre chambre = new Chambre(appAdd.get("localisation"),Integer.parseInt(appAdd.get("prix")),Integer.parseInt(appAdd.get("taux")),"disponible",dimension);
                                                        listeChambre.add(chambre);

                                                    }
                                                    Appartement appartement = new Appartement(appAdd.get("localisation"),Integer.parseInt(appAdd.get("prix")),Integer.parseInt(appAdd.get("taux")),
                                                            "disponible",Integer.parseInt(appAdd.get("nombrePiece")),listeChambre);

                                                    service.addLocalAppart(appartement);
                                                }
                                                break;
                                            case 5:
                                                break;
                                            case 6:
                                                service.flushEcran();
                                                choix = 7;
                                                break;
                                             default:
                                                 System.out.print("\n\t\t\t Erreur de saisie");
                                                 choix = 3;
                                                 break;
                                         }

                                        break;
                                    case 4:

                                        break;
                                    case 5:

                                        break;
                                    case 6:
                                        service.flushEcran();
                                        System.out.println("\n");
                                        System.out.println(" Hey A la prochaine ❤️🥵 ");
                                        System.out.println("\n");
                                        break;
                                    default:
                                        break;
                                }
                                
                            }while(choix!=6 );
                            //service.flushEcran();

                        }
                        else{
                            service.flushEcran();
                            System.out.println("\n");
                            System.out.println(" 😂😂😂 Mails ou mot de passe incorrecte 😂😂😂");
                            System.out.println("\n");

                        }
                    case 4:
                        break;
                    default:
                        service.flushEcran();
                        System.out.println("\n\t\t\t");
                        System.out.println("\n\t\t\t Hey 😂😂😂 faudrait faire attention a ce que tu tapes Mr wane");
                        System.out.println("\n\t\t\t");

                }
            }while(choix!=4);


        }

        public static int menuVisiteur()
        {
            System.out.println("\u001B[31m");
            System.out.print("\n\t\t\t🏠🏠🏠🏠🏡🏘️🏗️🏭🏢 BIENVENUE SUR GATOBOOKING 🏠🏠🏠🏡🏘️🏗️🏭🏢🏬🏠🏠");
            System.out.print("\n\t\t\t|                       1-Lister les Locaux disponibles       |");
            System.out.print("\n\t\t\t|                       2-Creer un compte                     |");
            System.out.print("\n\t\t\t|                       3-Se connecter                        |");
            System.out.print("\n\t\t\t|                       4-Quitter                             |");
            System.out.print("\n\t\t\t---------------------------------------------------------------");
            System.out.print("\n\t\t\tFaites votre choix : ");
            try{
                choix = Integer.parseInt(scanner.nextLine());
                return choix;
            } catch (Exception e) {
                service.flushEcran();
                System.out.println("\n");
                System.out.println(" Hey 😂😂😂 faudrait faire attention a ce que tu tapes");
                System.out.println("\n");
                return choix=5;
            }
            
        }

        public static int menuGestionnaire(){
           service.flushEcran();
            System.out.print("\n\t\t\t🏠🏠🏠🏠🏡🏘️🏗️🏭🏢 BIENVENUE SUR L'ESPACE DE GESTION 🏠🏠🏠🏡🏘️🏗️🏭🏢🏬🏠🏠");
            System.out.print("\n\t\t\t| 1-Voirs toutes réservations  en cours                             |");
            System.out.print("\n\t\t\t| 2-Valider reservation                                             |");
            System.out.print("\n\t\t\t| 3-Gerer les Locaux                                                |");
            System.out.print("\n\t\t\t| 4-Gerer les clients                                               |");
            System.out.print("\n\t\t\t| 5-Modifier les informations de mon compte                         |");
            System.out.print("\n\t\t\t| 6-Se deconnecter                                                  |");
            System.out.print("\n\t\t\t---------------------------------------------------------------");
            System.out.print("\n\t\t\tFaites votre choix : ");
            try{
                choix = Integer.parseInt(scanner.nextLine());
                return choix;
            } catch (Exception e) {
                service.flushEcran();
                System.out.println("erreur de saisie");
                return choix=7;
            }
            
        }
        public static int menuClient(){
            service.flushEcran();
            System.out.println
                    ("********************** BIENVENUE SUR L'ESPACE CLIENT **************************"
                            + "\n 1-Voirs Mes  réservations"
                            + "\n 2-Voirs les Locaux disponible"
                            + "\n 3-Faire une  reservation"
                            + "\n 4-Voir mes infos"
                            + "\n 5-Se deconnecter");
            System.out.print("Faites votre choix : ");
            try{
                choix = Integer.parseInt(scanner.nextLine());
                return choix;
            } catch (Exception e) {
                service.flushEcran();
                System.out.println("erreur de saisie");
                return choix=6;
            }
           

        }

        public static int menuGestionLocaux(){
            service.flushEcran();
             System.out.print("\n\t\t\t🏠🏠🏠🏠🏡🏘️🏗️🏭🏢 GERER VOS LOCAUX ICI 🏠🏠🏠🏡🏘️🏗️🏭🏢🏬🏠🏠");
             System.out.print("\n\t\t\t|                1-Voirs les Locaux  disponibles        |");
             System.out.print("\n\t\t\t|                2-Voirs les Locaux reservés            |");
             System.out.print("\n\t\t\t|                3-Supprimer un local                   |");
             System.out.print("\n\t\t\t|                4-Ajouter un local                     |");
             System.out.print("\n\t\t\t|                5-Modifier un local                    |");
             System.out.print("\n\t\t\t|                6-Quitter                              |");
             System.out.print("\n\t\t\t---------------------------------------------------------------");
             System.out.print("\n\t\t\tFaites votre choix : ");
             try{
                 choix = Integer.parseInt(scanner.nextLine());
                 
             } catch (Exception e) {
                 service.flushEcran();
                 System.out.println("erreur de saisie");
                 return choix=7;
             }
             finally {
                 return choix;
             }
 
         }


    }
