package model;

import model.Boat;
import model.Board;

import java.util.ArrayList;

public class HumanPlayer {

    private Board board;
    private ArrayList<Boat> boatList;
    private ArrayList<Position> missedTileList;
    private ArrayList<Position> hitTileList;
    int nbMissShot = 0;
	int nbHitShot = 0;

	
    public int getNbMissShot() {
		return nbMissShot;
	}

	public void setNbMissShot(int nbMissShot) {
		this.nbMissShot = nbMissShot;
	}

	public int getNbHitShot() {
		return nbHitShot;
	}

	public void setNbHitShot(int nbHitShot) {
		this.nbHitShot = nbHitShot;
	}

	public ArrayList<Position> getHitTileList() {
		return hitTileList;
	}

	public void setHitTileList(ArrayList<Position> hitTileList) {
		this.hitTileList = hitTileList;
	}

	public void setBoatList(ArrayList<Boat> boatList) {
		this.boatList = boatList;
	}

	public void setMissedTileList(ArrayList<Position> missedTileList) {
		this.missedTileList = missedTileList;
	}

	public HumanPlayer(Board b, ArrayList<Boat>boatList){
		board=b;
		this.boatList= boatList;
		missedTileList=new ArrayList<Position>();
		hitTileList=new ArrayList<Position>();
	}

    public boolean lost(){
        boolean reponse = false;
        return reponse;
    }

    public boolean tileTouched(){
        boolean reponse = false;
        return reponse;
    }

    public void gettingShot(Position p){}

    public Board getBoard() {
        return board;
    }

    public ArrayList<Boat> getBoatList() {
        return boatList;
    }

   
    
    public void setBoard(model.Board board) {
        this.board = board;
    }

    public void setListeBateau(ArrayList<Boat> boatList) {
        this.boatList = boatList;
    }


	public ArrayList<Position> getMissedTileList() {
		// TODO Auto-generated method stub
		 return missedTileList;
	}

}
