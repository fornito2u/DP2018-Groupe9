package model;

import java.util.ArrayList;

import javax.swing.text.Position;

import model.Boat;

public class Board {
	
	final public static int LINESIZE = 10;
	
    private int[][] board;

    public Board(int[][] plateau) {}
    
    public Board(ArrayList<Boat>listBateau) {}

    public void hit(Position p) {}

    public void sinkBoat(Boat b){}

    public boolean checkBoatPresence(Position p){
        boolean reponse = false;
        return reponse;
    }
    
	public int getValue(int x, int y) {
		return board[x][y] ;
		}

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

}
