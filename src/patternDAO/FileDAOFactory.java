package patternDAO;

public class FileDAOFactory extends AbstractDAOFactory {

    FileDAO FileDAO;

    public FileDAOFactory(){}

    public patternDAO.FileDAO getFileDAO() {
        return FileDAO;
    }

    public void setFileDAO(patternDAO.FileDAO fileDAO) {
        FileDAO = fileDAO;
    }

}
