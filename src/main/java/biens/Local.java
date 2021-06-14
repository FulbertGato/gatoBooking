package biens;



import interfaces.IAffiche;
import services.Service;
import java.util.ArrayList;

public class Local implements IAffiche {
    protected final int FORMAT = 4;
    protected String ref;
    public String getRef() {
        return this.ref;
    }

  

    protected String localisation;

   
    protected float prix;

    public float getPrix() {
        return this.prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    protected float tauxLocation;

    public float getTauxLocation() {
        return this.tauxLocation;
    }

    public void setTauxLocation(float tauxLocation) {
        this.tauxLocation = tauxLocation;
    }
    protected String etat;
    Service service = new Service();
    ArrayList<Local> listeLocaux = new ArrayList<Local>();
    
    public Local(String localisation, float prix, float tauxLocation,  String etat) {
        ref=generateReference();
        this.localisation = localisation;
        this.prix = prix;
        this.tauxLocation = tauxLocation;
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }

    public String getLocalisation() {
        return this.localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String generateReference() {
        listeLocaux  =  service.convertisseursJsonArrayLocal();
        String nombreZero = "";
        int nombreCompte = listeLocaux.size();
        String nombreDeCompteString = String.valueOf(++nombreCompte);
        for(int i=1; i<=(FORMAT - nombreDeCompteString.length()); i++)
        {
            nombreZero += "0";
        }
        listeLocaux.clear();
        return "REF"+nombreZero + nombreDeCompteString;
   
    }
    
    @Override
    public String affichage() {
          
        return    "\n\t\t\t Reference⚧️🛃🛂 :"+ref
                 +"\n\t\t\t Localisation🗺️: " + localisation
                 +"\n\t\t\t Prix : "+prix
                 +"\n\t\t\t Taux Location💵💵 : "+tauxLocation
                 +"\n\t\t\t Etat : "+etat;
    }
}

