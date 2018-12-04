package modele;

import javax.swing.text.Position;

public class Plateau {

    private int[][] plateau;

    public Plateau() {}

    public void toucher(Position p) {}

    public void coulerBateau(Bateau b){}

    public boolean verifierPresenceBateau(Position p){
        boolean reponse = false;
        return reponse;
    }

    public int[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(int[][] plateau) {
        this.plateau = plateau;
    }

}
