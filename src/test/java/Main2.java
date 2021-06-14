
import formulaires.ReservationForm;
import services.Service;
import validator.Validation;

public class Main2 {
    
    
    static Service service = new Service();
    static Validation validation = new Validation();
    static ReservationForm form = new ReservationForm();

    public static void main(String[] args) {

       // form.doReservationForm();
       service.validReservation("RES00001");
        //System.out.print(reservation.affichage());
       
    }
}

