package patternStrategie;



import java.util.ArrayList;
import java.util.Random;

import model.Position;
import model.Board;

public class RandomShot implements Strategie {

	private Random random = new Random();
	
	public Position getNextShot(ArrayList<Position> listHitShot, ArrayList<Position> listMissShot) {
        
        Position position = new Position(random.nextInt(Board.LINESIZE), random.nextInt(Board.LINESIZE));
        while (listMissShot.contains(position) || listHitShot.contains(position)) {
            position = new Position(random.nextInt(Board.LINESIZE), random.nextInt(Board.LINESIZE));
        }

        return position;
    }
	
	public String toString() {
    	return "RandomShot";
    }

}
