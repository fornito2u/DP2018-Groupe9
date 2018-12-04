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
    Position caseSelectionee;

    public NavalBattle() {}

    public void tirer(){}

    public void creerPartie(){}

    public boolean estValide(Position p){
        boolean reponse = false;
        return reponse;
    }

    public void changerJoueurCourant(){}

    public void stockCaseSelectionnee(Position p){}

    public void sauvegarderPartie(){}

    public void chargerPartie(String nom){}

    public patternStrategie.Strategie getStrategie() {
        return Strategie;
    }

    public patternFactory.EraFactory getEpoqueFactory() {
        return EraFactory;
    }

    public patternDAO.AbstractDAOFactory getAbstractDAOFactory() {
        return AbstractDAOFactory;
    }

    public model.HumanPlayer getJoueurHumain() {
        return HumanPlayer;
    }

    public model.AIPlayer getJoueurOrdinateur() {
        return AIPlayer;
    }

    public Position getCaseSelectionee() {
        return caseSelectionee;
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

    public void setCaseSelectionee(Position caseSelectionee) {
        this.caseSelectionee = caseSelectionee;
    }

}
