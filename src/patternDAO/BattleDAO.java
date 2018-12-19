package patternDAO;

import model.NavalBattle;

public abstract class BattleDAO {
	public abstract void saveGame(NavalBattle nb, String fileName);
	public abstract NavalBattle loadGame(String fileName);

}
