package services;
import biens.Appartement;
import biens.Chambre;
import biens.Local;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import interfaces.IService;
import reservation.Reservation;
import utilisateurs.Personne;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Service implements IService {
    ArrayList<Personne> listeUtilisateurs= new ArrayList<Personne>();
    ArrayList<Local> listeLocaux= new ArrayList<Local>();
    ArrayList<Reservation> listesDesReservations= new ArrayList<Reservation>();

    JSONArray locauxListJson = jsonFile("src\\main\\java\\model\\locaux.json");
    JSONArray locauxAppListJson = jsonFile("src\\main\\java\\model\\appartement.json");
    JSONArray ChambreAppListJson = jsonFile("src\\main\\java\\model\\locauxApp.json");
    JSONArray reservationJson = jsonFile("src\\main\\java\\model\\reservation.json");

    File fileClients = new File("src\\main\\java\\model\\utilisateurs.json");
    File filesReservations = new File("src\\main\\java\\model\\reservation.json");
    File fileLocals = new File("src\\main\\java\\model\\locaux.json");

    Type typeUtilisateurs = new TypeToken<ArrayList<Personne>>(){}.getType();
    Type typeLocal = new TypeToken<ArrayList<Local>>(){}.getType();
    Type typeChambre = new TypeToken<ArrayList<Chambre>>(){}.getType();
    Type typeReservations = new TypeToken<ArrayList<Reservation>>(){}.getType();

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
/*
    public Reservation searchReservation(String res) {

        listesDesReservations  = convertisseursJsonArrayReservation();
        for (Reservation reservation : listesDesReservations) {
           if (reservation != null) {
                if (reservation.getIdReservation().equals(res)) {
                    //System.out.println(personne.affichage()); 
                    return reservation;
                }
           }
        }
        listesDesReservations.clear();
        return null;
    }
    */
   

    @Override
    public Personne searchUtilisateurs(String nci) {

        listeUtilisateurs = convertisseursJsonArrayPersonne();
        for (Personne personne : listeUtilisateurs) {
           if (personne != null) {
                if (personne.getNci().equals(nci)) {
                    //System.out.println(personne.affichage()); 
                    return personne;
                }
           }
        }
      //  listeUtilisateurs.clear();
        return null;
    }

    @Override
    public boolean addUtilisateur(Personne personne) {
       //recuperation base de donner
        listeUtilisateurs = convertisseursJsonArrayPersonne();
        //ajout du client a la liste
        
        listeUtilisateurs.add(personne);
        try {
            FileWriter writer = new FileWriter(fileClients);
           // String json = gson.toJson(listeUtilisateurs);
           gson.toJson(listeUtilisateurs,writer);
           writer.flush();
           writer.close();
           listeUtilisateurs.clear();
           return true;
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean loginToApp(String login, String password) {
        listeUtilisateurs = convertisseursJsonArrayPersonne();
        if(searchUtilisateurs(login) != null && searchUtilisateurs(login).getPassword().equals(password)){
            listeUtilisateurs.clear();
            return true;
        }
        listeUtilisateurs.clear();
        return false;
    }

    @Override
    public boolean removePersonneClient(Personne personne) {
        listeUtilisateurs = convertisseursJsonArrayPersonne();
        for (Personne p: listeUtilisateurs) {
            if (p != null) {
                 if (p == personne) {
                     System.out.println(p.affichage());
                     listeUtilisateurs.remove(p);
                     return true;
                 }
            }
         }
        listeUtilisateurs.clear();
        return false;
    }

    @Override
    public void listingLocal() {
        listeLocaux  = convertisseursJsonArrayLocal();
        for(Local local : listeLocaux){
            if (local != null) {
                if (! local.getEtat().equals("reserve")) {    
                    System.out.println(local.affichage());
                }
            }
         }
       listeLocaux.clear();
    }

    @Override
    public boolean addChambre(Chambre chambre) {
        JSONObject objLoc = new JSONObject();
        listeLocaux=convertisseursJsonArrayLocal();
        objLoc.put("ref", chambre.getRef());
        objLoc.put("localisation", chambre.getLocalisation());
        objLoc.put("prix", chambre.getPrix());
        objLoc.put("tauxLocation", chambre.getTauxLocation());
        objLoc.put("dimension", chambre.getDimension());
        objLoc.put("etat", chambre.getEtat());
        locauxListJson.add(objLoc);
      /*  listeLocaux.add(chambre);
        try {
            FileWriter writer = new FileWriter(fileLocals);
            gson.toJson(listeLocaux,writer);
            writer.flush();
            writer.close();
            listeLocaux.clear();
        } catch (IOException e) {
        
            e.printStackTrace();
        }
        */
        
        writeJsonArray(locauxListJson,"src\\main\\java\\model\\chambre.json");
        return true;
    }
    
public boolean addLocalAppart(Appartement appartement){
        JSONObject objApp = new JSONObject();
        JSONObject objChambre = new JSONObject();
       // listeLocaux=convertisseursJsonArrayLocal();
       
        objApp.put("ref", appartement.getRef());
        objApp.put("localisation", appartement.getLocalisation());
        objApp.put("prix",  appartement.getPrix());
        objApp.put("tauxLocation", appartement.getTauxLocation());
        objApp.put("nombrePiece", appartement.getNombreDepiece());
        objApp.put("type", "appartement");
        locauxAppListJson.add(objApp);
        writeJsonArray(locauxAppListJson,"src\\main\\java\\model\\appartement.json");
       /* listeLocaux.add(appartement);
       
        try {
            FileWriter writer = new FileWriter(fileLocals);
            gson.toJson(listeLocaux,writer);
            writer.flush();
            writer.close();
            listeLocaux.clear();
        } catch (IOException e) {
            
            e.printStackTrace();
        }*/

        for(Chambre chambre:appartement.getListeChambre()){

            objChambre.put("ref", chambre.getRef());
            objChambre.put("localisation", chambre.getLocalisation());
            objChambre.put("prix", chambre.getPrix());
            objChambre.put("tauxLocation", chambre.getTauxLocation());
            objChambre.put("dimension", chambre.getDimension());
            objChambre.put("etat", chambre.getEtat());
            ChambreAppListJson.add(objChambre);
        }
        writeJsonArray(ChambreAppListJson,"src\\main\\java\\model\\locauxApp.json");
        
        return true;
}
    @Override
    public boolean addReservation(Reservation reservation) {
        JSONObject objReservation = new JSONObject();
        objReservation.put("idReservation", reservation.getIdReservation());
        objReservation.put("clientNci", reservation.getClientNci());
        objReservation.put("localRef", reservation.getLocalRef());
        objReservation.put("finLoc", reservation.getFinLoc());
        objReservation.put("etat", reservation.getEtat());
        objReservation.put("coutReservation", reservation.getCoutReservation());
        objReservation.put("createAt", reservation.getCreateAt());
        reservationJson.add(objReservation);
        writeJsonArray(reservationJson,"src\\main\\java\\model\\reservation.json");
        return true;
    }

    public void listReservationsEnCours(){
        listesDesReservations  = convertisseursJsonArrayReservation();
        for (Reservation reservation : listesDesReservations) {
            if (reservation != null) {
                if(reservation.getEtat().equals("EN COURS"))
                     System.out.print(reservation.affichage());
            }
        }
        listesDesReservations.clear();

    }

    @Override
    public boolean cancelReservation(int id) {
        return false;
    }

    @Override
    public void validReservation(String id) {
        listesDesReservations  = convertisseursJsonArrayReservation();

         for(Reservation reservation:listesDesReservations){

            if(reservation.getIdReservation().equals(id)){

                reservation.setEtat("valider");
                try {
                   FileWriter writer = new FileWriter("src\\main\\java\\model\\reservation.json");
                   gson.toJson(listesDesReservations,writer);
                   writer.flush();
                   writer.close();
                   listesDesReservations.clear();
                   
                    
                } catch (IOException e) {
                    e.printStackTrace();
                    
                }
            }


        }

    }

    public  void seeReservationByclient(String clientNci){
        listesDesReservations  = convertisseursJsonArrayReservation();
        for(Reservation reservation:listesDesReservations){

            if(reservation.getClientNci().equals(clientNci)){
                System.out.print(reservation.affichage());
            }



        }
    }



    @Override
    public boolean removeLocal(String ref) {
        return false;
    }


    @Override
    public String getRole(String nci) {
        listeUtilisateurs = convertisseursJsonArrayPersonne();
        for (Personne personne : listeUtilisateurs) {
            if (personne != null) {
                 if (personne.getNci().equals(nci)) {
                     //System.out.println(personne.affichage()); 
                     return personne.getRole();
                 }
            }
         }

        listeUtilisateurs.clear();
        return null;
    }

    @Override
    public int cout(int prix, int taux) {
        return 0;
    }

    public ArrayList<Personne> convertisseursJsonArrayPersonne(){
        try {
          //fileClients = new File("src\\main\\java\\model\\utilisateurs.json");
          return listeUtilisateurs = gson.fromJson(new FileReader(fileClients), typeUtilisateurs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
   
    

    public ArrayList<Local> convertisseursJsonArrayLocal(){
        try {
            File fileLocals = new File("src\\main\\java\\model\\locaux.json");
          return listeLocaux = gson.fromJson(new FileReader(fileLocals), typeLocal);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeJsonArray(JSONArray jsonArray, String path) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(jsonArray.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public JSONArray jsonFile(String path) {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonFile = new JSONArray();
        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);
            jsonFile = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jsonFile;

    }


    public void flushEcran(){

        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public void pauseEcran(){
        System.out.println("\n\t\t\t Veuillez appuyer sur une touche apres avoir terminer ");
        new java.util.Scanner(System.in).nextLine();
    }

    public ArrayList<Reservation> convertisseursJsonArrayReservation(){
        try {

            return listesDesReservations = gson.fromJson(new FileReader(filesReservations), typeReservations);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}