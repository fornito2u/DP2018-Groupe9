package patternFactory;

import java.util.ArrayList;
import java.util.Random;

import model.Boat;
import model.Board;
import model.Position;

public abstract class EraFactory {

	final public static Random random = new Random();

    public ArrayList<Boat> createBoat() {
        ArrayList<Boat> boatList = new ArrayList<>();

        boatList.add(getVeryLongBoat());
        boatList.add(getLongBoat());
        boatList.add(getMiddleBoat());
        boatList.add(getMiddleBoat());
        boatList.add(getShortBoat());
        
        boolean parcoursNormal = random.nextBoolean();

        int zone = 0;
        int sizeHalfLine = Board.LINESIZE / 2;

        for (int i = 0; i < boatList.size() - 1; i++) {
            int xZone = zone % 2;
            int yZone = (int) zone / 2;

            Boat boat = parcoursNormal ? boatList.get(i) : boatList.get((boatList.size()-1)-i);

            int xBoat, yBoat;

            if (boat.getOrientation()) {      

                xBoat = random.nextInt(sizeHalfLine-1);
                yBoat = (boat.getSize() == sizeHalfLine) ? 0 
                                                            : random.nextInt(sizeHalfLine - boat.getSize());

                boat.setPosition(new Position(xZone*sizeHalfLine + xBoat, yZone*sizeHalfLine + yBoat));
            } else {

                xBoat = (boat.getSize() == sizeHalfLine) ? 0 
                                                            : random.nextInt(sizeHalfLine - boat.getSize());
                yBoat = random.nextInt(sizeHalfLine-1);

                boat.setPosition(new Position(xZone*sizeHalfLine + xBoat, yZone*sizeHalfLine + yBoat));                
            }

            zone++;
        }

        Boat bateau = parcoursNormal ? boatList.get(boatList.size() - 1) : boatList.get(0);
        bateau.setPosition(new Position(sizeHalfLine-1, sizeHalfLine-1));

        return boatList;
    }
    
    protected abstract Boat getBateauTresLong();
    protected abstract Boat getBateauLong();
    protected abstract Boat getBateauMoyen();
    protected abstract Boat getBateauCourt();

}
