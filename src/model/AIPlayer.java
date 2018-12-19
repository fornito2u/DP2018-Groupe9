package model;

import model.Boat;
import model.Board;
import patternStrategie.Strategie;

import java.util.ArrayList;

public class AIPlayer {

    private Board board;
    private ArrayList<Boat> boatList;
    private ArrayList<Position> tileList;
    
    ArrayList<Position> hitTileList;
	ArrayList<Position> missTileList;

	// Stocke le nombre de tirs réussis et ratés effectué par le joueur
	// Ce n'est pas la même valeur que la taille des deux listes du dessus
	// Puisque ces listes stockent aussi toutes les cases d'un bateau coulé,
	int nbMissShot = 0;
	int nbHitShot = 0;

	ArrayList<Boat> listeBateau;
	Board plateau;
	
	
	public ArrayList<Position> getHitTileList() {
		return hitTileList;
	}

	public void setHitTileList(ArrayList<Position> hitTileList) {
		this.hitTileList = hitTileList;
	}

	public ArrayList<Position> getMissTileList() {
		return missTileList;
	}

	public void setMissTileList(ArrayList<Position> missTileList) {
		this.missTileList = missTileList;
	}

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

	public Strategie getStrategie() {
		return strategie;
	}

	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}

	public ArrayList<Boat> getListeBateau() {
		return listeBateau;
	}

	public Board getPlateau() {
		return plateau;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setBoatList(ArrayList<Boat> boatList) {
		this.boatList = boatList;
	}

	public void setTileList(ArrayList<Position> tileList) {
		this.tileList = tileList;
	}

	private Strategie strategie;

    public AIPlayer(Board p, ArrayList<Boat>listbat, Strategie strat){}

    public boolean lost(){
        boolean reponse = false;
        return reponse;
    }

    public boolean tileTouched(){
        boolean reponse = false;
        return reponse;
    }

    public void gettingShot(Position p){}

    public Position getShotPosition(){
        Position position = null;
        return position;
    }

    public model.Board getBoard() {
        return board;
    }

    public ArrayList<Boat> getBoatList() {
        return boatList;
    }

    public ArrayList<Position> getTileList() {
        return tileList;
    }

    public void setPlateau(model.Board board) {
        this.board = board;
    }

    public void setListeBateau(ArrayList<Boat> boatList) {
        this.boatList = boatList;
    }

    public void setListeCases(ArrayList<Position> tileList) {
        this.tileList = tileList;
    }

}
