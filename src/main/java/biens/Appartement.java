package biens;

import services.Service;

import java.util.ArrayList;

public class Appartement extends Local{
    
    private int nombreDepiece;
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private ArrayList<Chambre> listeChambre = new ArrayList<Chambre>();
   Service service = new Service();
    public ArrayList<Chambre> getListeChambre() {
        return this.listeChambre;
    }

    public void setListeChambre(ArrayList<Chambre> listeChambre) {
        this.listeChambre = listeChambre;
    }



    public Appartement(String localisation, int  prix, int tauxLocation, String etat,int nombrePiece, ArrayList<Chambre> listeChambre) {
        super(localisation, prix, tauxLocation, etat);
        this.listeChambre = listeChambre;
        this.type="appartement";
        this.nombreDepiece= nombrePiece;
    }


    public int getNombreDepiece() {
        return this.nombreDepiece;
    }

    public void setNombreDepiece(int nombreDepiece) {
        this.nombreDepiece = nombreDepiece;
    }

    public void affichageApp(){

       System.out.println(super.affichage()+"\n\t\t\t Type : "+getType()+"\n\t\t\tNombre de piece: "+getNombreDepiece());
     //  System.out.println("Ce appartement a :"+getNombreDepiece()+" de pieces");
       for(Chambre chambre: listeChambre ){
          System.out.println(chambre.affichage()); 
          // service.pauseEcran();
    }
}
}
