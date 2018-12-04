package model;

import javax.swing.text.Position;

public abstract class Boat {

    protected int length;
    protected int hp;
    protected Position position;

    public Boat(){}

    public void decreaseHP(){}

    public abstract void applyBonus();

    public int getLength() {
        return length;
    }

    public int getHp() {
        return hp;
    }

    public Position getPosition() {
        return position;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
