package model;

public abstract class Boat {

	protected boolean orientation;
	protected int health;
	protected int size;
	protected Position position;

	public Boat(int health, int size, Position position, boolean orientation) {
		this.health = health;
		this.size = size;
		this.position = position;
		this.orientation = orientation;
	}

	public boolean decreaseHealth() {
		health--;

		if (health == 0) {
			return true;
		}
		return false;
	}

	public boolean getOrientation(){
		return orientation;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getSize(){
		return size;
	}
	
	public void setPosition(Position p) {
		position = p;
	}
	
	public Position getPos(){
		return this.position;
	}
	
	public int getPosX(){
		return position.getX();
	}
	
	public int getPosY(){
		return position.getY();
	}

	public String toString() {
		return "(" + health + ", " + size + ", " + position + ", " + orientation + ")";
	}

}
