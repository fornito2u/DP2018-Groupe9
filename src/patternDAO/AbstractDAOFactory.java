package patternDAO;

public abstract class AbstractDAOFactory {

    FichierDAOFactory fichierDAOFactory;

    public AbstractDAOFactory(){}

    public FichierDAOFactory getFileDAOFactory() {
        return fichierDAOFactory;
    }

    public void setFileDAOFactory(FichierDAOFactory fichierDAOFactory) {
        this.fichierDAOFactory = fichierDAOFactory;
    }

}
