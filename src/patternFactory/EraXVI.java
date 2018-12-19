package patternFactory;

import java.util.ArrayList;
import model.Boat;
import model.BoatType1;


public class EraXVI extends EraFactory {

	protected Boat getVeryLongBoat() {
        return new BoatType1(1, 5, null, random.nextBoolean());
    }

    protected Boat getLongBoat() {
        return new BoatType1(1, 4, null, random.nextBoolean());
    }

    protected Boat getMiddleBoat() {
        return new BoatType1(1, 3, null, random.nextBoolean());
    }

    protected Boat getShortBoat() {
        return new BoatType1(1, 2, null, random.nextBoolean()); 
    }

}
