package model;

import javax.swing.text.Position;

public class Board {

	// Tableau d'entier qui représente le plateau de jeu.
	// Les entiers prennent les valeurs suivantes : 
	// 1 Pour la présence de bateau
	// 2 Si la case ne contient pas de bateau
	// -1 Si la case contient un bateau touché
	// -2 Si la case contient un bateau coulé
    private int[][] plateau;

    public Board() {}

    public void toucher(Position p) {}

    public void coulerBateau(Boat b){}

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
