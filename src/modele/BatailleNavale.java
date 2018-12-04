package modele;

import patternDAO.AbstractDAOFactory;
import patternFactory.EpoqueFactory;
import patternStrategie.Strategie;

import java.util.Observable;

import javax.swing.text.Position;

public class BatailleNavale extends Observable {

    Strategie Strategie;
    EpoqueFactory EpoqueFactory;
    AbstractDAOFactory AbstractDAOFactory;
    JoueurHumain JoueurHumain;
    JoueurOrdinateur JoueurOrdinateur;
    Position caseSelectionee;

    public BatailleNavale() {}

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

    public patternFactory.EpoqueFactory getEpoqueFactory() {
        return EpoqueFactory;
    }

    public patternDAO.AbstractDAOFactory getAbstractDAOFactory() {
        return AbstractDAOFactory;
    }

    public modele.JoueurHumain getJoueurHumain() {
        return JoueurHumain;
    }

    public modele.JoueurOrdinateur getJoueurOrdinateur() {
        return JoueurOrdinateur;
    }

    public Position getCaseSelectionee() {
        return caseSelectionee;
    }

    public void setStrategie(patternStrategie.Strategie strategie) {
        Strategie = strategie;
    }

    public void setEpoqueFactory(patternFactory.EpoqueFactory epoqueFactory) {
        EpoqueFactory = epoqueFactory;
    }

    public void setAbstractDAOFactory(patternDAO.AbstractDAOFactory abstractDAOFactory) {
        AbstractDAOFactory = abstractDAOFactory;
    }

    public void setJoueurHumain(modele.JoueurHumain joueurHumain) {
        JoueurHumain = joueurHumain;
    }

    public void setJoueurOrdinateur(modele.JoueurOrdinateur joueurOrdinateur) {
        JoueurOrdinateur = joueurOrdinateur;
    }

    public void setCaseSelectionee(Position caseSelectionee) {
        this.caseSelectionee = caseSelectionee;
    }

}
