package patternFactory;

import model.Boat;


public class EraXVI extends EraFactory {

	protected Boat getVeryLongBoat() {
        return new Boat(1, 5, null, random.nextBoolean());
    }

    protected Boat getLongBoat() {
        return new Boat(1, 4, null, random.nextBoolean());
    }

    protected Boat getMiddleBoat() {
        return new Boat(1, 3, null, random.nextBoolean());
    }

    protected Boat getShortBoat() {
        return new Boat(1, 2, null, random.nextBoolean()); 
    }

}
