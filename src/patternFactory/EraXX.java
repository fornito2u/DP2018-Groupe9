package patternFactory;

import model.Boat;

public class EraXX extends EraFactory {
	
	protected Boat getVeryLongBoat() {
        return new Boat(2, 5, null, random.nextBoolean());
    }

    protected Boat getLongBoat() {
        return new Boat(2, 4, null, random.nextBoolean());
    }

    protected Boat getMiddleBoat() {
        return new Boat(2, 3, null, random.nextBoolean());
    }

    protected Boat getShortBoat() {
        return new Boat(2, 2, null, random.nextBoolean()); 
    }


}
	

