package model;

import patternDAO.AbstractDAOFactory;
import patternFactory.EraFactory;
import patternStrategie.Strategie;

import java.util.Observable;

import javax.swing.text.Position;

public class NavalBattle extends Observable {

    Strategie Strategie;
    EraFactory EraFactory;
    AbstractDAOFactory AbstractDAOFactory;
    HumanPlayer HumanPlayer;
    AIPlayer AIPlayer;
    Position selectedTile;

    public NavalBattle() {}

    public void shoot(){}

    public void createGame(){}

    public boolean isValid(Position p){
        boolean answer = false;
        return answer;
    }

    public void changeCurrentPlayer(){}

    public void stockSelectedTile(Position p){}

    public void saveGame(){}

    public void loadGame(String name){}

    public patternStrategie.Strategie getStrategie() {
        return Strategie;
    }

    public patternFactory.EraFactory getEpoqueFactory() {
        return EraFactory;
    }

    public patternDAO.AbstractDAOFactory getAbstractDAOFactory() {
        return AbstractDAOFactory;
    }

    public model.HumanPlayer getHumanPlayer() {
        return HumanPlayer;
    }

    public model.AIPlayer getIAPlayer() {
        return AIPlayer;
    }

    public Position getSelectedTile() {
        return selectedTile;
    }

    public void setStrategie(patternStrategie.Strategie strategie) {
        Strategie = strategie;
    }

    public void setEpoqueFactory(patternFactory.EraFactory eraFactory) {
        EraFactory = eraFactory;
    }

    public void setAbstractDAOFactory(patternDAO.AbstractDAOFactory abstractDAOFactory) {
        AbstractDAOFactory = abstractDAOFactory;
    }

    public void setJoueurHumain(model.HumanPlayer humanPlayer) {
        HumanPlayer = humanPlayer;
    }

    public void setJoueurOrdinateur(model.AIPlayer aIPlayer) {
        AIPlayer = aIPlayer;
    }

    public void setCaseSelectionee(Position selectedTile) {
        this.selectedTile = selectedTile;
    }

}
