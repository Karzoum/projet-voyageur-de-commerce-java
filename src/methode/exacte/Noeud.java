package methode.exacte;

import java.util.BitSet;

import villechemin.Ville;
public class Noeud {

    private byte[][] contrainte;

    // Fields
    private int borneInferieur;
    private int nblignes, nbCols;
    // -1 indicates no edge from row to column allowed,
    // 1 indicates that edge from row to column required,
    // 0 indicates that edge from row to column allowed
    private short[] nodeCosts; // Used to compute smallest and
    // nexSmallest
    private int edges; // Used by estTour query
    private int tourCost; // Used by estTour query
    private byte[] trip;
    private String nodeAsString; // Used by estTour query
    private boolean isLoop = false;
    static BitSet b; // Used by isCycle and initialized in TSPUI

    public Noeud(int nblignes, int nbCols) {
        this.nblignes = nblignes;
        this.nbCols = nbCols;
        this.nodeCosts = new short[nbCols + 1];
        this.contrainte = new byte[nblignes + 1][nbCols + 1];
        this.trip = new byte[nblignes + 1];
    }

    public void assignConstraint(byte value, int ligne,
            int col) {
        contrainte[ligne][col] = value;
        contrainte[col][ligne] = value;
    }

    public int assignerVille(Ville p, int edgeIndex) {
        // Advance edgeIndex until edge that is unconstrained is found
        Ville pt = p;
        while (edgeIndex < Branche_Bound.lesVilles.size() &&
                contrainte[(int) Math.abs(pt.getX())][(int) Math.abs(pt.getY())] != 0) {
            edgeIndex++;
            if (edgeIndex < Branche_Bound.lesVilles.size()) {
                pt = (Ville) Branche_Bound.lesVilles.get(edgeIndex);
            }
        }
        if (edgeIndex < Branche_Bound.lesVilles.size()) {
            if (pt.getX() < 0) {
                assignConstraint((byte) -1, (int) Math.abs(pt.getX()),
                        (int) Math.abs(pt.getY()));
            } else {
                assignConstraint((byte) 1, (int) pt.getX(),
                        (int) pt.getY());
            }
        }
        return edgeIndex;
    }

    public void setContrainte(byte[][] contrainte) {
        this.contrainte = contrainte;
    }

    public void ajouterArretNonAutorise() {
        for (int ligne = 1; ligne <= nblignes; ligne++) {
            // Count the number of paths from row.
            // If the count exceeds one then disallow all other paths
            // from row
            int count = 0;
            for (int col = 1; col <= nbCols; col++) {
                if (ligne != col && contrainte[ligne][col] == 1) {
                    count++;
                }
            }
            if (count >= 2) {
                for (int col = 1; col <= nbCols; col++) {
                    if (ligne != col && contrainte[ligne][col] == 0) {
                        contrainte[ligne][col] = -1;
                        contrainte[col][ligne] = -1;
                    }
                }
            }
        }
        // Check to see whether the presence of a col causes a premature
        // circuit
        for (int ligne = 1; ligne <= nblignes; ligne++) {
            for (int col = 1; col <= nbCols; col++) {
                if (ligne != col && estCycle(ligne, col) &&
                        nbCities(b) < nblignes) {
                    if (contrainte[ligne][col] == 0) {
                        contrainte[ligne][col] = -1;
                        contrainte[col][ligne] = -1;
                    }
                }
            }
        }
    }

    public void ajouterArretRequit() {
        for (int ligne = 1; ligne <= nblignes; ligne++) {
            // Count the number of paths excluded from row
            // If the count equals numCols - 3, include all remaining
            // paths
            int count = 0;
            for (int col = 1; col <= nbCols; col++) {
                if (ligne != col && contrainte[ligne][col] == -1) {
                    count++;
                }
            }
            if (count >= nblignes - 3) {
                for (int col = 1; col <= nbCols; col++) {
                    if (ligne != col && contrainte[ligne][col] == 0) {
                        contrainte[ligne][col] = 1;
                        contrainte[col][ligne] = 1;
                    }
                }
            }
        }
    }

    public void calculLimiteInferieur() {
        int lowB = 0;
        for (int ligne = 1; ligne <= nblignes; ligne++) {
            for (int col = 1; col <= nbCols; col++) {
                nodeCosts[col] = Branche_Bound.c.cost(ligne, col);
            }
            nodeCosts[ligne] = Short.MAX_VALUE;
            // Eliminate edges that are not allowed
            for (int col = 1; col <= nbCols; col++) {
                if (contrainte[ligne][col] == -1) {
                    nodeCosts[col] = Short.MAX_VALUE; // Taken out of
                    // contention
                }
            }
            int[] required = new int[nbCols - 1]; // Natural indexing
            int numRequired = 0;
            // Determine whether an edge is required
            for (int col = 1; col <= nbCols; col++) {
                if (contrainte[ligne][col] == 1) {
                    numRequired++;
                    required[numRequired] = nodeCosts[col];
                    nodeCosts[col] = Short.MAX_VALUE; // Taken out of
                    // contention
                }
            }
            int plusCourt = 0, nextplusCourt = 0;
            if (numRequired == 0) {
                plusCourt = plusCourt();
                nextplusCourt = nextplusCourt();
            } else if (numRequired == 1) {
                plusCourt = required[1];
                nextplusCourt = plusCourt();
            } else if (numRequired == 2) {
                plusCourt = required[1];
                nextplusCourt = required[2];
            }
            if (plusCourt == Short.MAX_VALUE) {
                plusCourt = 0;
            }
            if (nextplusCourt == Short.MAX_VALUE) {
                plusCourt = 0;
            }
            lowB += plusCourt + plusCourt;
        }
        borneInferieur = lowB; // This is twice the actual lower bound
    }

    public void setTour() {
        byte path = 0;
        for (int col = 2; col <= nbCols; col++) {
            if (contrainte[1][col] == 1) {
                path = (byte) col;
                break;
            }
        }
        tourCost = Branche_Bound.c.cost(1, path);
        trip[1] = path;
        int ligne = 1;
        int col = path;
        int from = ligne;
        byte pos = path;
        nodeAsString = "" + ligne + " " + col;
        while (pos != ligne) {
            for (byte colonne = 1; colonne <= nbCols; colonne++) {
                if (colonne != from && contrainte[pos][colonne] == 1) {
                    from = pos;
                    pos = colonne;
                    nodeAsString += " " + pos;
                    tourCost += Branche_Bound.c.cost(from, pos);
                    trip[from] = pos;
                    break;
                }
            }
        }
    }

    // Requêtes
    public int tourCost() {
        return tourCost;
    }

    public byte[] trip() {
        return trip;
    }

    public byte getContrainte(int ligne, int col) {
        return contrainte[ligne][col];
    }

    public byte[][] getcontrainte() {
        return contrainte;
    }

    public int borneInferieur() {
        return borneInferieur;
    }
    
    private boolean estCycle(int ligne, int col) {
        // b = new BitSet(numRows + 1);
        for (int i = 0; i < nblignes + 1; i++) {
            b.clear(i);
        }
        b.set(ligne);
        b.set(col);
        int from = ligne;
        int pos = col;
        int edges = 1;
        boolean quit = false;
        while (pos != ligne && edges <= nbCols && !quit) {
            quit = true;
            for (int colonne = 1; colonne <= nbCols; colonne++) {
                if (colonne != from && contrainte[pos][colonne] == 1) {
                    edges++;
                    from = pos;
                    pos = colonne;
                    b.set(pos);
                    quit = false;
                    break;
                }
            }
        }
        return pos == ligne || edges >= nbCols;
    }

    public boolean estTour() {
        // Determine path from 1
        int path = 0;
        for (int col = 2; col <= nbCols; col++) {
            if (contrainte[1][col] == 1) {
                path = col;
                break;
            }
        }
        if (path > 0) {
            boolean cycle = estCycle(1, path);
            return cycle && nbCities(b) == nblignes;
        } else {
            return false;
        }
    }

    public String tour() {
        return nodeAsString;
    }

    public String toString() {
        // String representation of constraint matrix
        String returnString = "";
        for (int ligne = 1; ligne <= nblignes; ligne++) {
            for (int col = ligne + 1; col <= nbCols; col++) {
                if (contrainte[ligne][col] == 1) {
                    returnString += "" + ligne + col + " ";
                } else if (contrainte[ligne][col] == -1) {
                    returnString += "*" + ligne + col + " ";
                }
            }
        }
        return returnString;
    }

    // Internal methods
    private int plusCourt() {
        int s = nodeCosts[1];
        int index = 1;
        for (int i = 2; i <= nbCols; i++) {
            if (nodeCosts[i] < s) {
                s = nodeCosts[i];
                index = i;
            }
        }
        short temp = nodeCosts[1];
        nodeCosts[1] = nodeCosts[index];
        nodeCosts[index] = temp;
        return nodeCosts[1];
    }

    private int nextplusCourt() {
        int ns = nodeCosts[2];
        int index = 2;
        for (int i = 2; i <= nbCols; i++) {
            if (nodeCosts[i] < ns) {
                ns = nodeCosts[i];
                index = i;
            }
        }
        short temp = nodeCosts[2];
        nodeCosts[2] = nodeCosts[index];
        nodeCosts[index] = temp;
        return nodeCosts[2];
    }

    private int nbCities(BitSet b) {
        int num = 0;
        for (int i = 1; i <= nblignes; i++) {
            if (b.get(i)) {
                num++;
            }
        }
        return num;
    }

}
