package validator;
import java.util.regex.Pattern; 
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public final class Validation {
    /**
     * Validate email
     * Validate nom
     * Validate tel
     * Validate nci
     */
// Java program to check if an email address
// is valid using Regex.
    public static boolean isValidMail(String email)
    {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null || email == "")
            return false;
        return pat.matcher(email).matches();
    }

    public static boolean estVide(String champ) {
        if (champ != "" || champ != " ")
        {
            return false;
        }
        return true;
    }

    public static boolean isValidNci(String nci)
    {
        String nciRegex = "(^[1|2])([0-9]{3})(19[4-9]\\d|20[0-1]\\d|2020|2021)([0-9]{5})";

        Pattern pat = Pattern.compile(nciRegex);
        if (nci == null || nci == "")
            return false;

        return pat.matcher(nci).matches();
    }

    public static boolean isValidTel(String tel)
    {
        String telRegex = "^(\\+|00)(221)(70|76|77|78|33)([0-9]{7})";

        Pattern pat = Pattern.compile(telRegex);
        if (tel == null || tel == "")
            return false;
        return pat.matcher(tel).matches();
    }

    public static boolean isInt(String valeur){
        return valeur.matches("-?\\d+");
    }

    public static boolean isValidDate(String date) {
       String pattern="dd-MM-yyyy";
       
        try {
            Date simple = new SimpleDateFormat(pattern).parse(date);
            Format format = new SimpleDateFormat(pattern);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
            LocalDate today = LocalDate.now();
            LocalDate value = LocalDate.parse(date, dtf);
                if (value.isBefore(today)) {
                    if (!date.equals(format.format(simple)))
                    System.out.println("Date1 is before Date2");
                    return false;
                }
            return true;
        } catch(ParseException e) {
            return false;
        }
    }



}
