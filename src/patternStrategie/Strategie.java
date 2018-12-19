package patternStrategie;

import java.util.ArrayList;

import model.Position;


public interface Strategie {

    public Position getNextShot(ArrayList<Position> listHitShot, ArrayList<Position> listMissShot);
  
}
