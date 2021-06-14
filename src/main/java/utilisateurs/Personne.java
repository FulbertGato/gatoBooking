package utilisateurs;

import interfaces.IAffiche;
import reservation.Reservation;

import java.util.ArrayList;

public  class Personne implements IAffiche {

    private String nci;
    private String nomComplet;
    private String tel;
    private String adresse;
    private String email;
    private String password;
    private String role;
    private ArrayList<Reservation> listeReservationClients;
    
    public Personne(String nci, String nomComplet, String tel, String adresse, String email, String password,String role) {

        this.nci = nci;
        this.nomComplet = nomComplet;
        this.tel = tel;
        this.adresse = adresse;
        this.email = email;
        this.password = password;
        this.role = role;

    }

    @Override
    public String affichage() {
        return  " \n Numéro de carte d'identité : " + getNci()
                + "\n  Nom complet : " + getNomComplet()
                + "\n Téléphone: " + getTel()
                + "\n Addresse: " + getAdresse()
                + "\n email: " + getEmail();
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getNci() {
        return nci;
    }

    public void setNci(String nci) {
        this.nci = nci;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    };

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Reservation> getListeReservationClients() {
        return listeReservationClients;
    }

    public void setListeReservationClients(ArrayList<Reservation> listeReservationClients) {
        this.listeReservationClients = listeReservationClients;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
