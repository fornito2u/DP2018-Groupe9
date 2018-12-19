package model;

import javax.swing.text.Position;

import model.Boat;
import model.Board;
import patternStrategie.Strategie;

import java.util.ArrayList;

public class AIPlayer {

    private Board board;
    private ArrayList<Boat> boatList;
    private ArrayList<Position> tileList;

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
