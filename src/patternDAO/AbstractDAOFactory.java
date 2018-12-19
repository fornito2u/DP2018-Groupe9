package patternDAO;

public abstract class AbstractDAOFactory {

    public static AbstractDAOFactory getAbstractDAOFactory() {
        return new CsvFactory();
    }

    public abstract BattleDAO getBattleDAO();

}
