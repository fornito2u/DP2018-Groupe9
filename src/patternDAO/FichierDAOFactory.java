package patternDAO;

public class FichierDAOFactory extends AbstractDAOFactory {

    FichierDAO FichierDAO;

    public FichierDAOFactory(){}

    public patternDAO.FichierDAO getFileDAO() {
        return FichierDAO;
    }

    public void setFileDAO(patternDAO.FichierDAO fichierDAO) {
        FichierDAO = fichierDAO;
    }

}
