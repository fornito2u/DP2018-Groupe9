package patternDAO;

import patternDAO.AbstractDAOFactory;
import model.NavalBattle;

public class CsvReader {
	
	private NavalBattle battle;

	public CsvReader() {
		battle = new NavalBattle(AbstractDAOFactory.getAbstractDAOFactory());
	}
	
	public NavalBattle run(String fileName) {
		return battle;
	}

}
