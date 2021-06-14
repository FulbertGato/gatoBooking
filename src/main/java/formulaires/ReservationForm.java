package formulaires;
import services.Service;
import validator.Validation;

import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
public class ReservationForm {

    //string dure;
    public static Scanner scanner = new Scanner(System.in);
    Validation validation = new Validation();
    Service service = new Service();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    Map<String, String> formData = new Hashtable<String,String>();
    public Map<String, String> doReservationForm(){

        System.out.println("\n");
        System.out.println(" **********************DEMANDE DE RESERVATION ****************************");
        System.out.println("\n");

        String dure;
        String nbrePersonne;
        String ref;
            do{
                System.out.print("\nEntrer la reference de l'appart  : ");
                ref = scanner.nextLine();
                if(Validation.isInt(ref));
                {
                    System.out.print("Hey 😂😂😂! Verifier votre saisie: \n");
                }

        }while(Validation.isInt(ref));

            do{
                System.out.print("\nEntrer la date de depart  exemple: 10-04-2021 : ");
                dure = scanner.nextLine();
                if(!Validation.isValidDate(dure))
                {
                    System.out.print("Hey 😂😂😂! Vous devez bien remplir ce champ: \n");
                }
           }while(!Validation.isValidDate(dure));

        do{
            System.out.print("\nEntrer le nombre de personne  : ");
             nbrePersonne = scanner.nextLine();
            if(!Validation.isInt(nbrePersonne))
            {
                System.out.print("Hey 😂😂😂! Vous devez remplir ce champ: \n");
            }

        }while(!Validation.isInt(nbrePersonne) || nbrePersonne == "0");


        formData.put("ref", ref);
        formData.put("dure", dure);
        return formData;

}

public Map<String, String> validateReservationForm(){
    String ref;
            do{
                System.out.print("\nEntrer la reference de la reservation  : ");
                ref = scanner.nextLine();
                if(Validation.isInt(ref));
                {
                    System.out.print("Hey 😂😂😂! Verifier votre saisie: \n");
                }

        }while(Validation.isInt(ref));

        formData.put("ref", ref);
        return formData;
    
}
}
