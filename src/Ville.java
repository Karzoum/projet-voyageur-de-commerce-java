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
}
