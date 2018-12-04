package patternStrategie;

import javax.swing.text.Position;

import model.Board;

public interface Strategie {

    public Position getNextShot(Board p);

}
