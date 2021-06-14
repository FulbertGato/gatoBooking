package formulaires;
import services.Service;
import validator.Validation;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class PersonneForms {

    String nci;
    String tel;
    String nomComplet;
    String adresse;
    String email;
    String password;
    public static Scanner scanner = new Scanner(System.in);
    Validation validation = new Validation();
    Service service = new Service();
    Map<String, String> formData = new Hashtable<String,String>();

    ///////////////////////////// Formulaire d'inscription /////////////////////////////////////////////////

    public Map<String, String> registerForm(){

        System.out.println("\n");
        System.out.println(" **********************PAGE D'INSCRIPTION****************************");
        System.out.println("\n");

        do{
            System.out.print("Entrez votre numero de carte d'identite: ");
            nci = scanner.nextLine();
            if(!Validation.isValidNci(nci)){

                System.out.println("\n");
                System.out.println(" Hey 😂😂😂 faudrait faire attention a ce que tu tapes");
                System.out.println("\n");

            }
        }while(!Validation.isValidNci(nci));

       //  if (service.searchUtilisateurs(nci) == null)
      //  {

            /*-------------------------------validation nom complet------------------------------------*/

            do{
                System.out.print("Entrer votre nom : ");
                String nom = scanner.nextLine();
                System.out.print("Entrer votre prenom : ");
                String prenom = scanner.nextLine();
                nomComplet = nom+" "+prenom;
                //System.out.print("Votre nom au complet est : "+nomComplet);

                if(Validation.estVide(nomComplet)){
                    System.out.print("Hey 😂😂😂! Vous devez remplir au moins un champ : \n");
                }

            }while (Validation.estVide(nomComplet));
            System.out.print("\nVotre nom au complet est : \n"+nomComplet);

            /*--------------------------------------------------------------------------------------------*/

            /*-----------------------------------validation telephonne------------------------------------*/
            do{
                System.out.print("\nEntrer votre numero de téléphone avec le code pays +221 ou 00221: ");
                tel = scanner.nextLine();
                if(!Validation.isValidTel(tel)){
                    System.out.print(" Hey 😂😂😂! Vous devez saisir un numero de telephone correct: \n");
                }

            }while(!Validation.isValidTel(tel));
            /*--------------------------------------------------------------------------------------------*/

            /*-----------------------------------validation adresse du client------------------------------------*/
            do{
                System.out.print("\nEntrer l'adresse du client : ");
                adresse = scanner.nextLine();
                if(Validation.estVide(adresse))
                {
                    System.out.print("Hey 😂😂😂! Vous devez remplir ce champ: \n");
                }
            }while (Validation.estVide(adresse));
            /*--------------------------------------------------------------------------------------------*/

            /*-----------------------------------validation email du client ------------------------------------*/
            do{
                System.out.print("Entrer le email: ");
                email = scanner.nextLine();
                if(!Validation.isValidMail(email))
                {
                    System.out.print("Hey 😂😂😂!Vous devez saisir un email correct: \n");
                }
            }while (Validation.isValidMail(email));
            /*--------------------------------------------------------------------------------------------*/

            /*-----------------------------------validation mot de passe ------------------------------------*/
            do{
                System.out.print("Entrer votre mot de passe : ");
                password = scanner.nextLine();
                if(Validation.estVide(password))
                {
                    System.out.print("Hey 😂😂😂!Vous devez remplir ce champ: \n");
                }
            }while (Validation.estVide(password));

            /*-----------------------------------------------------------------------------------------------*/
            formData.put("nci", nci);
            formData.put("nomComplet", nomComplet);
            formData.put("telephone", tel);
            formData.put("adresse", adresse);
            formData.put("email", email);
            formData.put("motDePasse", password);
            return formData;
     /*   }else{
            
            System.out.print("\n\n\t\t\t|************************************************************************");
            System.out.print("\n\n\t\t\t|ce nci existe deja veuillez vous connecter 🚶🚶🚶 \n");
            System.out.print("\n\n\t\t\t|************************************************************************");
            return null;
        }
        */
    }

    public Map<String, String> loginForm(){
        Map<String, String> formData = new Hashtable<String,String>();

        System.out.println("\n");
        System.out.println(" **********************PAGE DE CONNEXION*****************************");
        System.out.println("\n");

        do{
            System.out.print("Entrez votre numero de carte d'identite: ");
            nci = scanner.nextLine();
            if(!Validation.isValidNci(nci)){
                System.out.print("verifier votre saisie  \n");
            }

        }while(!Validation.isValidNci(nci));

        do{
            System.out.print("Entrer votre mot de passe : ");
            password = scanner.nextLine();
            if(Validation.estVide(password))
            {
                System.out.print("Vous devez remplir ce champ: \n");
            }
        }while (Validation.estVide(password));

        formData.put("nci", nci);
        formData.put("motDePasse", password);
        return formData;



    }
}
