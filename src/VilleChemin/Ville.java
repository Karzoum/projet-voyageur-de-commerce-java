package villechemin;
public class Ville {

    private int x;
    private int y;
    private int numVille;
    /**
     * @param numVille
     */

    public Ville(int numVille) {
        this.x=(int)(Math.random()*100);
        this.y=(int)(Math.random()*100);
        this.numVille = numVille;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNumVille() {
        return numVille;
    }
    
    public void setNumVille(int numVille) {
        this.numVille = numVille;
    }

    public double distanceEntreVille(Ville destination) {
        int x = Math.abs(getX() - destination.getX());
        int y = Math.abs(getY() - destination.getY());
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public String toString() {
        return "Ville [numVille=" + numVille + ", x=" + x + ", y=" + y + "]";
    }
}
