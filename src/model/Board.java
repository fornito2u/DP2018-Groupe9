package model;

import java.util.ArrayList;

import javax.swing.text.Position;

import model.Boat;

public class Board {

	// Tableau d'entier qui représente le plateau de jeu.
	// Les entiers prennent les valeurs suivantes : 
	// 1 Pour la présence de bateau
	// 2 Si la case ne contient pas de bateau
	// -1 Si la case contient un bateau touché
	// -2 Si la case contient un bateau coulé
    private int[][] board;

    public Board(int[][] plateau) {}
    
    public Board(ArrayList<Boat>listBateau) {}

    public void hit(Position p) {}

    public void sinkBoat(Boat b){}

    public boolean checkBoatPresence(Position p){
        boolean reponse = false;
        return reponse;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

}
