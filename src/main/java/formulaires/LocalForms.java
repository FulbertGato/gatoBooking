package formulaires;

import services.Service;
import validator.Validation;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;


import biens.Chambre;

public class LocalForms<taux, prix, localisation> {
    public static Scanner scanner = new Scanner(System.in);
    Validation validation = new Validation();
    Service service = new Service();
    Map<String, String> formData = new Hashtable<String,String>();
    String localisation;
    String dimension;
    String prix;
    String taux;
    String nombrePiece;
    ArrayList<Chambre> listChambre ;
   

/////////////////////////////////// Formulaire D'ajout de chambre /////////////////////////////////////////////////

public Map<String, String> addChambre(){

    System.out.print("\n\t\t\t");
    System.out.print("\n\t\t\t ********************** AJOUTER UNE CHAMBRE******************************");
    do{
        System.out.print("\n\t\t\t  Entrez la localisation                                   : ");
        localisation = scanner.nextLine();
            if(Validation.estVide(localisation))
                {
                    System.out.print("\n\t\t\tHey 😂😂😂! Vous devez remplir ce champ: \n");
                }
    }while (Validation.estVide(localisation));
    do{
        System.out.print("\n\t\t\t  Entrez la dimension de la chambre sans le m2  Exemple: 100    : ");
        dimension = scanner.nextLine();
        if(dimension.matches("-?\\d+")){
            if  (Integer.valueOf(dimension)  < 0 ){
                dimension="asuxe2541";
            }
        }else if(!dimension.matches("-?\\d+")){
            dimension="asuxe2541";
        }
    }while(dimension.equals("asuxe2541"));
    do{
        System.out.print("\n\t\t\t  Entrez le prix  de location par mois    Exemple: 100000       : ");
        prix = scanner.nextLine();
        if(prix.matches("-?\\d+")){
            if  (Integer.valueOf(prix)  < 0 ){
                prix="asuxe2541";
            }
        }else if(!prix.matches("-?\\d+")){
            prix="asuxe2541";
        }
    }while(prix.equals("asuxe2541"));
    do{
        System.out.print("\n\t\t\t  Entrez le taux de location en pourcentage Exemple: 5           : ");
        taux = scanner.nextLine();
        if(taux.matches("-?\\d+")){
            if  (Integer.valueOf(taux)  < 0 && Integer.valueOf(taux) > 100 ){
                taux="asuxe2541";
            }
        }else if(!taux.matches("-?\\d+")){
            taux="asuxe2541";
        }
    }while(taux.equals("asuxe2541"));
            formData.put("dimension", dimension);
            formData.put("localisation", localisation);
            formData.put("prix", prix);
            formData.put("taux", taux);
            formData.put("etat", "disponible");
            formData.put("type", "chambre");
            return formData;
}

/////////////////////////////////// Formulaire D'ajout d'un appartements /////////////////////////////////////////////////
public Map<String, String> addAppartements(){

    
System.out.print("\n\t\t\t");
System.out.print("\n\t\t\t ********************** AJOUTER UN APPARTEMENT ******************************");
do{
    System.out.print("\n\t\t\t  Entrez le nombre de Piece   Exemple: 3    : ");
    nombrePiece= scanner.nextLine();
    if(Integer.valueOf(nombrePiece)  < 3){
        System.out.print("\n\t\t\t ********************** Le nombre de piece doit etre superieur à 3 ******************************");
    }

    if(!Validation.isInt(nombrePiece)){
        System.out.print("\n\t\t\t ********************** verifier votre saisie ******************************");
    }
}while(Validation.isInt(nombrePiece) && Integer.valueOf(nombrePiece) < 3 );

do{
    System.out.print("\n\t\t\t  Entrez la localisation Exemple: Londre   : ");
    localisation= scanner.nextLine();
    if(Validation.isInt(localisation)){
        System.out.print("\n\t\t\t ********************** verifier votre saisie ******************************");
    }
}while(Validation.isInt(localisation));


do{
    System.out.print("\n\t\t\t  Entrez le prix de l'appartements  Exemple: 1000000 ");
    prix= scanner.nextLine();
    if(!Validation.isInt(prix)){
        System.out.print("\n\t\t\t ********************** verifier votre saisie ******************************");
    }
}while(!Validation.isInt(prix) && Integer.valueOf(prix) > 0);

do{
    System.out.print("\n\t\t\t Entez le  Taux de location :  ");
    taux= scanner.nextLine();
    if(!Validation.isInt(taux)){
        System.out.print("\n\t\t\t ********************** verifier votre saisie ******************************");
    }
}while(!Validation.isInt(taux) && Integer.valueOf(taux) > 0);


            formData.put("nombrePiece", nombrePiece);
            formData.put("localisation", localisation);
            formData.put("prix", prix);
            formData.put("taux", taux);
            formData.put("etat", "disponible");
            //formData.put("listeChambre", String.valueOf(listChambre));
            return formData;
}
}

