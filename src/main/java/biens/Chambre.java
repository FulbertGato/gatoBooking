package biens;


public class Chambre extends Local{

    private int dimension;
    public Chambre( String localisation, int prix, int tauxLocation, String etat, int dimension) {
        super(localisation, prix, tauxLocation, etat);
        this.setDimension(dimension);
    }

    public int getDimension() {
        return dimension;
    }
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
    public String affichage(){  
      return super.affichage()+"\n\t\t\t Type : Chambre"+"\n\t\t\t Dimension : "+getDimension();  
    }
}
