package model;

import javax.swing.text.Position;
import java.util.ArrayList;

public class HumanPlayer {

    private Board board;
    private ArrayList<Boat> boatList;
    private ArrayList<Position> tileList;

    public HumanPlayer(){}

    public boolean lost(){
        boolean reponse = false;
        return reponse;
    }

    public boolean tileTouched(){
        boolean reponse = false;
        return reponse;
    }

    public void gettingShot(Position p){}

    public model.Board getBoard() {
        return board;
    }

    public ArrayList<Boat> getBoatList() {
        return boatList;
    }

    public ArrayList<Position> getTileList() {
        return tileList;
    }

    public void setBoard(model.Board board) {
        this.board = board;
    }

    public void setListeBateau(ArrayList<Boat> boatList) {
        this.boatList = boatList;
    }

    public void setListeCases(ArrayList<Position> tileList) {
        this.tileList = tileList;
    }

}
