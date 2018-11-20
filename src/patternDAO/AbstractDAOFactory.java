package patternDAO;

public abstract class AbstractDAOFactory {

    FileDAOFactory fileDAOFactory;

    public AbstractDAOFactory(){}

    public FileDAOFactory getFileDAOFactory() {
        return fileDAOFactory;
    }

    public void setFileDAOFactory(FileDAOFactory fileDAOFactory) {
        this.fileDAOFactory = fileDAOFactory;
    }

}
