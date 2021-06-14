package biens;


public class Chambre extends Local{

    private int dimension;
    private String type;

    

    

    public Chambre( String localisation, int prix, int tauxLocation, String etat, int dimension) {
        super(localisation, prix, tauxLocation, etat);
        this.type = "chambre";
        this.setDimension(dimension);
    }

    public int getDimension() {
        return dimension;
    }
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String affichage(){  
      return super.affichage()+"\n\t\t\t Type : "+getType()+"\n\t\t\t Dimension : "+getDimension();  
    }
}
