package methode.exacte;

import java.util.ArrayList;
import java.util.Random;

import villechemin.Ville;

public class Branche_Bound {

    private final int nblignes;
    private final int nbCols;
    private TimeInterval t = new TimeInterval();
    private int bestTour = Integer.MAX_VALUE / 4;
    private Noeud bestNoeud;
    public static ArrayList<Ville> lesVilles = new ArrayList<Ville>();
    public static Cout c;

    private int newNoeudCpt = 0;
    private int nbNouedEgale = 0; 
    private Random rnd = new Random();

    public Branche_Bound(short[][] Matrice, int size, int bestTour) {
        this.bestTour = bestTour;
        nblignes = nbCols = size;
        c = new Cout(nblignes, nbCols);
        for (int ligne = 0; ligne < nblignes; ligne++) {
            for (int col = 0; col < nbCols; col++) {
                c.assignerCout(Matrice[ligne][col], ligne, col);
            }
        }
    }

    public Branche_Bound(short[][] Matrix, int size) {
        nblignes = nbCols = size;
        c = new Cout(nblignes, nbCols);
        for (int ligne = 1; ligne <= size; ligne++) {
            for (int col = 1; col <= size; col++) {
                c.assignerCout(Matrix[ligne][col], ligne,
                        col);
            }
        }
    }

    public void generateSolution() {
        Ville pt;
        // Load lesVilles Vector of edge Villes
        for (int ligne = 1; ligne <= nblignes; ligne++) {
            for (int col = ligne + 1; col <= nbCols; col++) {
                pt = new Ville(ligne, col);
                lesVilles.add(pt);
                pt = new Ville(-ligne, -col);
                lesVilles.add(pt);
            }
        }
        // Create root noeud
        Noeud root = new Noeud(nblignes, nbCols);
        newNoeudCpt++;
        root.borneInferieur();
        System.out.println("Twice the lower bound for root noeud (no constraints): " + root.borneInferieur());
        // Apply the branch and bound algorithm
        t.startTiming();
        branchAndBound(root, -1);
        t.endTiming();
        if (bestNoeud != null) {
            System.out.println("\n\nCost of optimum tour: " + bestTour + "\nOptimum tour: " + bestNoeud.tour() +
                    "\nTotal of noeuds generated: " + newNoeudCpt +
                    "\nTotal number of noeuds pruned: " +
                    nbNouedEgale);
        } else {
            System.out.println(
                    "Tour obtained heuristically is the best tour.");
        }
        System.out.println("Elapsed time for entire algorithm: " + t
                .getElapsedTime() + " seconds.");
        System.out.println();
    }

    // Queries
    public int noeudsCreated() {
        return newNoeudCpt;
    }

    public int noeudsPruned() {
        return nbNouedEgale;
    }

    public String tour() {
        if (bestNoeud != null) {
            return bestNoeud.tour();
        } else {
            return "";
        }
    }

    public int tourCost() {
        return bestTour;
    }

    public byte[] trip() {
        if (bestNoeud != null) {
            return bestNoeud.trip();
        } else {
            return null;
        }
    }

    private void branchAndBound(Noeud noeud, int Index) {
        if (noeud != null && Index < lesVilles.size()) {
            Noeud filsGauche, filsDroit;
            int indexFilsGauche = 0, indexFilsDroit = 0;
            if (noeud.estTour()) {
                noeud.setTour();
                if (noeud.tourCost() < bestTour) {
                    bestTour = noeud.tourCost();
                    bestNoeud = noeud;
                    System.out.println("\n\nBest tour cost so far: " +
                            bestTour + "\nBest tour so far: " +
                            bestNoeud.tour() +
                            "\nNumber of noeuds generated so far: " +
                            newNoeudCpt +
                            "\nTotal number of noeuds pruned so far: " +
                            nbNouedEgale +
                            "\nElapsed time to date for branch and bound: " +
                            t.getElapsedTime() + " seconds.\n");
                }
            } else {
                if (noeud.borneInferieur() < 2 * bestTour) {
                    // Create left child noeud
                    filsGauche = new Noeud(nblignes, nbCols);
                    newNoeudCpt++;
                    if (newNoeudCpt % 1000 == 0) {
                        Ville p = (Ville) lesVilles.get(Index);
                        t.endTiming();
                        System.out.println(
                                "\nTotal number of noeuds created so far: " +
                                        newNoeudCpt +
                                        "\nTotal number of noeuds pruned so far: " +
                                        nbNouedEgale +
                                        "\nElapsed time to date for branch and bound: " +
                                        t.getElapsedTime() + " seconds.");
                    } else if (newNoeudCpt % 25 == 0) {
                        System.out.print(".");
                    }
                    if (newNoeudCpt % 10000 == 0 &&
                            bestNoeud != null) {
                        System.out.println(
                                "\n\nBest tour cost so far: " +
                                        bestTour + "\nBest tour so far: " +
                                        bestNoeud.tour());
                    }
                    filsGauche.setContrainte(copy(noeud.getcontrainte()));
                    if (Index != -1 &&
                            ((Ville) lesVilles.get(Index)).getX() > 0) {
                        Index += 2;
                    } else {
                        Index++;
                    }
                    if (Index >= lesVilles.size()) {
                        return;
                    }
                    Ville p = (Ville) lesVilles.get(Index);
                    indexFilsGauche = filsGauche.assignerVille(p, Index);
                    filsGauche.ajouterArretNonAutorise();
                    filsGauche.ajouterArretRequit();
                    filsGauche.ajouterArretNonAutorise();
                    filsGauche.ajouterArretRequit();
                    filsGauche.calculLimiteInferieur();

                    if (filsGauche.borneInferieur() >= 2 * bestTour) {
                        filsGauche = null;
                        nbNouedEgale++;
                    }

                    // Create right child noeud
                    filsDroit = new Noeud(nblignes, nbCols);
                    newNoeudCpt++;
                    if (newNoeudCpt % 1000 == 0) {
                        System.out.println(
                                "\nTotal number of noeuds created so far: " +
                                        newNoeudCpt +
                                        "\nTotal number of noeuds pruned so far: " +
                                        nbNouedEgale);
                    } else if (newNoeudCpt % 25 == 0) {
                        System.out.print(".");
                    }
                    filsDroit.setContrainte(copy(noeud.getcontrainte()));
                    if (indexFilsGauche >= lesVilles.size()) {
                        return;
                    }
                    p = (Ville) lesVilles.get(indexFilsGauche + 1);
                    indexFilsDroit = filsDroit.assignerVille(p, indexFilsGauche +1);
                    filsDroit.ajouterArretNonAutorise();
                    filsDroit.ajouterArretRequit();
                    filsDroit.ajouterArretNonAutorise();
                    filsDroit.ajouterArretRequit();
                    filsDroit.calculLimiteInferieur();

                    if (filsDroit.borneInferieur() > 2 * bestTour) {
                        filsDroit = null;
                        nbNouedEgale++;
                    }

                    if (filsGauche != null && filsDroit == null) {
                        branchAndBound(filsGauche, indexFilsGauche);
                    } else if (filsGauche == null &&
                            filsDroit != null) {
                        branchAndBound(filsDroit, indexFilsDroit);
                    } else if (filsGauche != null &&
                            filsDroit != null &&
                            filsGauche.borneInferieur() <= filsDroit.borneInferieur()) {
                        if (filsGauche.borneInferieur() < 2 * bestTour) {
                            branchAndBound(filsGauche,
                                    indexFilsGauche);
                        } else {
                            filsGauche = null;
                            nbNouedEgale++;
                        }
                        if (filsDroit.borneInferieur() < 2 * bestTour) {
                            branchAndBound(filsDroit,
                                    indexFilsDroit);
                        } else {
                            filsDroit = null;
                            nbNouedEgale++;
                        }
                    } else if (filsDroit != null) {
                        if (filsDroit.borneInferieur() < 2 * bestTour) {
                            branchAndBound(filsDroit,
                                    indexFilsDroit);
                        } else {
                            filsDroit = null;
                            nbNouedEgale++;
                        }
                        if (filsGauche.borneInferieur() < 2 * bestTour) {
                            branchAndBound(filsGauche,
                                    indexFilsGauche);
                        } else {
                            filsGauche = null;
                            nbNouedEgale++;
                        }
                    }
                }
            }
        }
    }

    private byte[][] copy(byte[][] constraint) {
        byte[][] toReturn = new byte[nblignes + 1][nbCols + 1];
        for (int ligne = 1; ligne <= nblignes; ligne++) {
            for (int col = 1; col <= nbCols; col++) {
                toReturn[ligne][col] = constraint[ligne][col];
            }
        }
        return toReturn;
    }

}
