package patternStrategie;

import modele.Plateau;

import javax.swing.text.Position;

public interface Strategie {

    public Position getProchainTir(Plateau p);

}
