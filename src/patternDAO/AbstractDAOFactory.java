package patternDAO;

public abstract class AbstractDAOFactory {

    public static CsvFactory getAbstractDAOFactory() {
        return new CsvFactory();
    }

    public abstract BattleDAO getBattleDAO();

}
