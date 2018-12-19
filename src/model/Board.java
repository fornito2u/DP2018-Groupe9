package model;

import java.util.ArrayList;

import model.Boat;
import modele.Bateau;
import modele.Position;

public class Board {
	
	final public static int LINESIZE = 10;
	
    private int[][] board;

    public Board(int[][] board){
		this.board=board;
	}
    
    public Board(ArrayList<Boat>boatList) {
    	board=new int[LINESIZE][LINESIZE];
		int size;
		boolean orientation;
		Position currentPos;
		
		for(int i=0;i<boatList.size();i++){
			size=boatList.get(i).getSize();
			orientation=boatList.get(i).getOrientation();
			currentPos=boatList.get(i).getPos();
			
			if(orientation){
				
				for(int y=currentPos.getY();y<currentPos.getY()+size;y++){
					if(this.board[currentPos.getX()][y]==0){
						this.board[currentPos.getX()][y]=1;
					}else{
						System.out.println("Erreur : Deux bâteaux ne peuvent pas êtres créés au même endroit");
					}
				}
			}else{
				//si le bateau est horizontal
				
				for(int x=currentPos.getX();x<currentPos.getX()+size;x++){
					if(this.board[x][currentPos.getY()]==0){
						this.board[x][currentPos.getY()]=1;
					}else{
						System.out.println("Erreur : Deux bâteaux ne peuvent pas êtres créés au même endroit");
					}
				}
			}
		}
    }

    public void hit(Position p) {
    	if(this.checkBoatPresence(p)==true){	
			board[p.getX()][p.getY()]=-1;;
		}
    }

    public void sinkBoat(Boat b, ArrayList<Position> hitList){
    	int size=b.getSize();
		boolean orientation=b.getOrientation();
		Position currentPos=b.getPos();
		if(orientation){
			for(int y=currentPos.getY();y<currentPos.getY()+size;y++){		
				this.board[currentPos.getX()][y]=-2;
				hitList.add(new Position(currentPos.getX(),y));
			}
		}else{
			for(int x=currentPos.getX();x<currentPos.getX()+size;x++){	
				this.board[x][currentPos.getY()]=-2;
				hitList.add(new Position(x,currentPos.getY()));
			}
		}
    }

    public boolean checkBoatPresence(Position p){
    	boolean b;
		int v=board[p.getX()][p.getY()];

		if(v==1){
			b=true;
		}else{
			b=false;
		}
		return b;
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
    
    public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int j = 0; j < LINESIZE; j++) {
			for (int i = 0; i < LINESIZE; i++) {
				sb.append(board[i][j] + " | ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}

}
