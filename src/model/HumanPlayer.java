package model;

import javax.swing.text.Position;
import java.util.ArrayList;

public class HumanPlayer {

    private Board Board;
    private ArrayList<Boat> ListeBateau;
    private ArrayList<Position> ListeCases;

    public HumanPlayer(){}

    public boolean avoirPerdu(){
        boolean reponse = false;
        return reponse;
    }

    public boolean caseEstTouche(){
        boolean reponse = false;
        return reponse;
    }

    public void subirTir(Position p){}

    public model.Board getPlateau() {
        return Board;
    }

    public ArrayList<Boat> getListeBateau() {
        return ListeBateau;
    }

    public ArrayList<Position> getListeCases() {
        return ListeCases;
    }

    public void setPlateau(model.Board board) {
        Board = board;
    }

    public void setListeBateau(ArrayList<Boat> listeBateau) {
        ListeBateau = listeBateau;
    }

    public void setListeCases(ArrayList<Position> listeCases) {
        ListeCases = listeCases;
    }

}
