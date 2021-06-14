package reservation;
import services.Service;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;

import interfaces.IAffiche;

public class Reservation implements IAffiche{
    private static final int FORMAT = 5;
    //private final String idReservation;
    protected String idReservation;
    private final String  createAt;
    private  String   finLoc;
    private String etat;
    private String clientNci;
    private String localRef;
    private int coutReservation;

    Service service = new Service();
    ArrayList<Reservation> listeReservation= new ArrayList<Reservation>();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

  
    public Reservation(String clientNci, String localRef, String finLoc, String etat, int coutReservation){
        idReservation = generateReferenceReservation();
        this.clientNci=clientNci;
        this.localRef=localRef;
        this.createAt=LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.finLoc=finLoc;;
        this.etat=etat;
        this.coutReservation=coutReservation;
        
    }

    public String getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    

    public String getFinLoc() {
        return finLoc;
    }

    public void setFinLoc(String finLoc) {
        this.finLoc = finLoc;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getClientNci() {
        return clientNci;
    }

    public void setClientNci(String clientNci) {
        this.clientNci = clientNci;
    }

    public String getLocalRef() {
        return localRef;
    }

    public void setLocalRef(String localRef) {
        this.localRef = localRef;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String generateReferenceReservation() {
        ArrayList<Reservation> listeReservation  =  service.convertisseursJsonArrayReservation();
     
        String nombreZero = "";
        int nombreCompte = listeReservation.size();
        String nombreDeCompteString = String.valueOf(++nombreCompte);
        for(int i=1; i<=(FORMAT - nombreDeCompteString.length()); i++)
        {
            nombreZero += "0";
        }
        listeReservation.clear();
        return "RES"+nombreZero + nombreDeCompteString;

    }

    public int getCoutReservation() {
        return coutReservation;
    }

    public void setCoutReservation(int coutReservation) {
        this.coutReservation = coutReservation;
    }

    public String getCreateAt() {
        return createAt;
    }

    @Override
    public String affichage() {
        
        return "\n\t\t\t Reference de la reservation: "+getIdReservation()
                +"\n\t\t\t Le nci du client: " + getClientNci()
                +"\n\t\t\t Refernce du Local : "+getLocalRef()
                +"\n\t\t\t Date de reservation : "+getCreateAt()
                +"\n\t\t\t Etat : "+getEtat()
                +"\n\t\t\t Cout : "+getCoutReservation();
    }
}
