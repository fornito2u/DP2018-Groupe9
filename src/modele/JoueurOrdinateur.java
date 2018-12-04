package modele;

import javax.swing.text.Position;
import java.util.ArrayList;

public class JoueurOrdinateur {

    private Plateau Plateau;
    private ArrayList<Bateau> ListeBateau;
    private ArrayList<Position> ListeCases;

    public JoueurOrdinateur(){}

    public boolean avoirPerdu(){
        boolean reponse = false;
        return reponse;
    }

    public boolean caseEstTouche(){
        boolean reponse = false;
        return reponse;
    }

    public void subirTir(Position p){}

    public Position recupPositionTir(){
        Position position = null;
        return position;
    }

    public modele.Plateau getPlateau() {
        return Plateau;
    }

    public ArrayList<Bateau> getListeBateau() {
        return ListeBateau;
    }

    public ArrayList<Position> getListeCases() {
        return ListeCases;
    }

    public void setPlateau(modele.Plateau plateau) {
        Plateau = plateau;
    }

    public void setListeBateau(ArrayList<Bateau> listeBateau) {
        ListeBateau = listeBateau;
    }

    public void setListeCases(ArrayList<Position> listeCases) {
        ListeCases = listeCases;
    }

}
