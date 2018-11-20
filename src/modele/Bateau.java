package modele;

import javax.swing.text.Position;

public abstract class Bateau {

    protected int longeur;
    protected int pv;
    protected Position position;

    public Bateau(){}

    public void diminuerVie(){}

    public abstract void appliquerBonus();

    public int getLongeur() {
        return longeur;
    }

    public int getPv() {
        return pv;
    }

    public Position getPosition() {
        return position;
    }

    public void setLongeur(int longeur) {
        this.longeur = longeur;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
