package patternDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import patternDAO.AbstractDAOFactory;
import model.NavalBattle;
import model.Boat;
import model.BoatType1;
import model.HumanPlayer;
import model.AIPlayer;
import model.Board;
import model.Position;
import patternStrategie.Strategie;
import patternStrategie.RandomShot;
import patternStrategie.CrossShot;

public class CsvReader {
	
	private NavalBattle battle;

	public CsvReader() {
		battle = new NavalBattle(AbstractDAOFactory.getAbstractDAOFactory());
	}
	
	public NavalBattle run(String fileName) {
		
		BufferedReader br = null;
		String line = "";
		String csvPositionSeparator = " , ";
		String csvBoardSeparator = "#";
		try {
			br = new BufferedReader(new FileReader(fileName));
			
			while (!(line = br.readLine()).matches("Board joueur human")) {
				if ((line == "0") || (line == "1")) {
					battle.setCurrentPlayer(Integer.parseInt(line));
				}
			}

			int[][] t = new int[10][10];
			int j = 0;
			while (!(line = br.readLine()).matches("Bateaux human")) {
				String[] ligne = line.split(csvBoardSeparator);
				
				for (int i = 0; i < t.length; i++) {
					t[i][j] = Integer.parseInt(ligne[i]);
				}
				j++;
			}
			Board p = new Board(t);

			ArrayList<Boat> humanBoat = new ArrayList<>();

			while (!(line = br.readLine()).matches("Cases touchees ordinateur")) {
				String[] ligne = line.split(csvPositionSeparator);
				humanBoat.add(new BoatType1(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[1]), new Position(Integer.parseInt(ligne[2]), Integer.parseInt(ligne[3])), Boolean.parseBoolean(ligne[4])));
			}

			HumanPlayer human = new HumanPlayer(p, humanBoat);
			
			while (!(line = br.readLine()).matches("Cases ratees ordinateur")) {
				String[] ligne = line.split(csvPositionSeparator);
				human.getHitTileList().add(new Position(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[1])));
			}
			
			while (!(line = br.readLine()).matches("Tirs reussis humain")) {
				String[] ligne = line.split(csvPositionSeparator);
				human.getMissedTileList().add(new Position(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[1])));
			}

			while (!(line = br.readLine()).matches("Tirs rates humain")) {
				human.setNbHitShot(Integer.parseInt(line));
			}
			
			while (!(line = br.readLine()).matches("Plateau joueur ordinateur")) {
				human.setNbMissShot(Integer.parseInt(line));
			}

			battle.setHumanPlayer(human);
			
			int[][] t2 = new int[10][10];
			int j2 = 0;
			while (!(line = br.readLine()).matches("Bateaux ordinateur")) {
				String[] ligne = line.split(csvBoardSeparator);
				for (int i = 0; i < t2.length; i++) {
					t2[i][j2] = Integer.parseInt(ligne[i]);
				}
				j2++;
			}
			Board p2 = new Board(t2);

			ArrayList<Boat> aiBoat = new ArrayList<>();
			
			while (!(line = br.readLine()).matches("Strategie ordinateur")) {
				String[] ligne = line.split(csvPositionSeparator);
				aiBoat.add(new BoatType1(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[1]), new Position(Integer.parseInt(ligne[2]), Integer.parseInt(ligne[3])), Boolean.parseBoolean(ligne[4])));
			}

			Strategie strategie = null;
			while (!(line = br.readLine()).matches("Cases touchees humain")) {
				if (line.matches("TirAleatoire"))
					strategie = new RandomShot();
				else
					strategie = new CrossShot();
			}

			AIPlayer ordinateur = new AIPlayer(p2, aiBoat, strategie);

			
			while (!(line = br.readLine()).matches("Cases ratees humain")) {
				String[] ligne = line.split(csvPositionSeparator);
				ordinateur.getHitTileList().add(new Position(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[1])));
			}

			while (!(line = br.readLine()).matches("Tirs reussis ordinateur")) {
				String[] ligne = line.split(csvPositionSeparator);
				ordinateur.getMissTileList().add(new Position(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[1])));
			}

			while (!(line = br.readLine()).matches("Tirs rates ordinateur")) {
				ordinateur.setNbHitShot(Integer.parseInt(line));
			}

			while ((line = br.readLine()) != null) {
				ordinateur.setNbMissShot(Integer.parseInt(line));
			}

			battle.setaIPlayer(ordinateur);


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			  if (br != null) {
				  try {
					  br.close();
				  } catch (IOException e) {
					  e.printStackTrace();
				  }
			  }
		  }
			
		
		return battle;
	}

}
