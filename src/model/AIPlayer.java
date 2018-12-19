package model;

import model.Boat;
import model.Board;
import patternStrategie.Strategie;

import java.util.ArrayList;

public class AIPlayer {

	private Board board;
	private ArrayList<Boat> boatList;
	private ArrayList<Position> hitTileList;
	private ArrayList<Position> missTileList;
	private int nbMissShot = 0;
	private int nbHitShot = 0;
	private Strategie strategie;

	public AIPlayer(Board p, ArrayList<Boat>listbat, Strategie strat){
		board=p;
		boatList=listbat;
		hitTileList=new ArrayList<Position>();
		missTileList=new ArrayList<Position>();
		this.strategie = strat;
	}

	public void gettingShot(Position p){
		if(board.checkBoatPresence(p)){
			int indiceB=this.searchBoat(p);
			assert(indiceB!=-1);
			if(boatList.get(indiceB).decreaseHealth()){
				board.sinkBoat(boatList.get(indiceB),hitTileList);

			}else{
				board.hit(p);
				hitTileList.add(p);
			}

			nbHitShot++;

		}else{
			missTileList.add(p);
			nbMissShot++;
		}
	}

	public int searchBoat(Position p){
		boolean found=false;
		Position pos;
		int size;
		int i=-1;
		while (!found && i<boatList.size()-1){
			i++;
			pos=boatList.get(i).getPos();
			size=boatList.get(i).getSize();
			boolean orientation=boatList.get(i).getOrientation();
			if(orientation){
				for(int l=0;l<size;l++){
					Position tempY=new Position(pos);	
					tempY.setY(tempY.getY()+l);
					if(p.compareTo(tempY)==0){
						found=true;
					}
				}
			}else{
				for(int l=0;l<size;l++){
					Position tempX=new Position(pos);
					tempX.setX(tempX.getX()+l);
					if(p.compareTo(tempX)==0){
						found=true;
					}
				}
			}
		}
		if(found){
			return i;
		}else{
			return -1;
		}
	}

	public boolean lost(){
		boolean lost = true;

		for (int i = 0; i < boatList.size(); i++) {
			if (boatList.get(i).getHealth() > 0) {
				lost = false;
				break;
			}
		}

		return lost;
	}

	public boolean tileTouched(Position p){
		return (missTileList.contains(p) || hitTileList.contains(p));
	}

	public Position getShotPosition(ArrayList<Position> hitTiles, ArrayList<Position> missTiles){
		return strategie.getNextShot(hitTiles, missTiles);
	}

	//--------------------------------------------------------------------------------------------------
	//-----------------------------------------GETTER & SETTER/-----------------------------------------
	//--------------------------------------------------------------------------------------------------	    

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


	public void setBoard(Board board) {
		this.board = board;
	}

	public void setBoatList(ArrayList<Boat> boatList) {
		this.boatList = boatList;
	}

	public model.Board getBoard() {
		return board;
	}

	public ArrayList<Boat> getBoatList() {
		return boatList;
	}

	public void setPlateau(model.Board board) {
		this.board = board;
	}

	public void setListeBateau(ArrayList<Boat> boatList) {
		this.boatList = boatList;
	}
}
