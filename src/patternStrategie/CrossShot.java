package patternStrategie;

import java.util.ArrayList;
import java.util.Random;

import model.Board;
import model.Position;

public class CrossShot implements Strategie {

    private boolean randomShot = false;

    private Random random = new Random();

    public Position getNextShot(ArrayList<Position> hitShotList, ArrayList<Position> missedShotList) {

        Position p = null;
        Position lastShotPosition = null;

        Position lastHitShotPosition = null;
        if (! hitShotList.isEmpty() )
        	lastHitShotPosition = hitShotList.get(hitShotList.size()-1);
        else
        	lastHitShotPosition = new Position(0, 0);

        Position lastMissedShotPosition = null;
        if (! missedShotList.isEmpty() )
        	lastMissedShotPosition = missedShotList.get(missedShotList.size()-1);
        else 
        	lastMissedShotPosition = new Position(0, 0);
            
        if (missedShotList.isEmpty() && hitShotList.isEmpty() )
            return new Position(0, 0);

        if (lastMissedShotPosition.compareTo(lastHitShotPosition) == 1)
            lastShotPosition = lastMissedShotPosition;
        else
            lastShotPosition = lastHitShotPosition;


        if (lastShotPosition.getY() >= Board.LINESIZE-1 && lastShotPosition.getX() >= Board.LINESIZE-2)
            randomShot = true;


        int nextX, nextY;

        if (randomShot) {
            Position position = new Position(random.nextInt(Board.LINESIZE), random.nextInt(Board.LINESIZE));

            while (missedShotList.contains(position) || hitShotList.contains(position)) {
                position = new Position(random.nextInt(Board.LINESIZE), random.nextInt(Board.LINESIZE));
            }

            nextX = position.getX();
            nextY = position.getY();
        } else {

            if (lastShotPosition.getX() == Board.LINESIZE-2) {
                nextX = 1;
                nextY = lastShotPosition.getY() + 1;
            
            } else if (lastShotPosition.getX() == Board.LINESIZE-1) {
                nextX = 0;
                nextY = lastShotPosition.getY() + 1;
            } else {
                nextX = lastShotPosition.getX() + 2;
                nextY = lastShotPosition.getY();
            }
        }

        return new Position(nextX, nextY);
    }
    
    public String toString() {
    	return "TirCroix";
    }

}
