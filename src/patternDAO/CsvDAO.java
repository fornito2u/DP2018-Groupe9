package patternDAO;

import model.NavalBattle;

public class CsvDAO extends BattleDAO {
	private static CsvDAO instance = null;
	
	private CsvDAO() {
		
	}
	
	public static CsvDAO getInstance() {
		if (instance == null)
			return new CsvDAO();
		return instance;
	}

	@Override
	public void saveGame(NavalBattle nb, String fileName) {
		new CsvWriter(nb, fileName);
		
	}

	@Override
	public NavalBattle loadGame(String fileName) {
		CsvReader r = new CsvReader();
		return r.run(fileName);
	}

}