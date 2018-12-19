package patternDAO;

public class CsvFactory extends AbstractDAOFactory {

	@Override
	public BattleDAO getBattleDAO() {
		return CsvDAO.getInstance();
	}

}
