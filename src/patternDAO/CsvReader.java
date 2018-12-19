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
			while (!(line = br.readLine()).matches("Boatx human")) {
				String[] ligne = line.split(csvBoardSeparator);
				
				for (int i = 0; i < t.length; i++) {
					t[i][j] = Integer.parseInt(ligne[i]);
				}
				j++;
			}
			Board p = new Board(t);

			ArrayList<Boat> Boatxhuman = new ArrayList<>();

			// on recupere les Boatx human
			while (!(line = br.readLine()).matches("Cases touchees ordinateur")) {
				String[] ligne = line.split(csvPositionSeparator);
				Boatxhuman.add(new BoatType1(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[1]), new Position(Integer.parseInt(ligne[2]), Integer.parseInt(ligne[3])), Boolean.parseBoolean(ligne[4])));
			}

			HumanPlayer human = new HumanPlayer(p, Boatxhuman);
			
			// on recupere la liste des cases touchees par le joueur ordinateur
			while (!(line = br.readLine()).matches("Cases ratees ordinateur")) {
				String[] ligne = line.split(csvPositionSeparator);
				human.getHitTileList().add(new Position(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[1])));
			}
			
			// on recupere la liste des cases ratees par le joueur ordinateur
			while (!(line = br.readLine()).matches("Tirs reussis human")) {
				String[] ligne = line.split(csvPositionSeparator);
				human.getListeCaseRate().add(new Position(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[1])));
			}

			// on recupere les tirs reussis du joueur human
			while (!(line = br.readLine()).matches("Tirs rates human")) {
				human.setNombreTirsReussis(Integer.parseInt(line));
			}
			
			// on recupere les tirs rates du joueur human
			while (!(line = br.readLine()).matches("Board joueur ordinateur")) {
				human.setNombreTirsRates(Integer.parseInt(line));
			}

			battle.sethuman(human);
			
			// on recupere le Board du joueur Ordinateur
			int[][] t2 = new int[10][10];
			int j2 = 0;
			while (!(line = br.readLine()).matches("Boatx ordinateur")) {
				String[] ligne = line.split(csvBoardSeparator);
				for (int i = 0; i < t2.length; i++) {
					t2[i][j2] = Integer.parseInt(ligne[i]);
				}
				j2++;
			}
			Board p2 = new Board(t2);

			ArrayList<Boat> BoatxOrdi = new ArrayList<>();
			
			// on recupere les Boatx ordi
			while (!(line = br.readLine()).matches("Strategie ordinateur")) {
				String[] ligne = line.split(csvPositionSeparator);
				BoatxOrdi.add(new BoatType1(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[1]), new Position(Integer.parseInt(ligne[2]), Integer.parseInt(ligne[3])), Boolean.parseBoolean(ligne[4])));
			}

			Strategie strategie = null;
			// on recupere la strategie
			while (!(line = br.readLine()).matches("Cases touchees human")) {
				if (line.matches("TirAleatoire"))
					strategie = new TirAleatoire();
				else
					strategie = new TirCroix();
			}

			JoueurOrdinateur ordinateur = new JoueurOrdinateur(p2, BoatxOrdi, strategie);

			
			// on recupere la liste des cases touchees par le joueur human
			while (!(line = br.readLine()).matches("Cases ratees human")) {
				String[] ligne = line.split(csvPositionSeparator);
				ordinateur.getTileTouched().add(new Position(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[1])));
			}

			// on recupere la liste des cases ratees par le joueur human
			while (!(line = br.readLine()).matches("Tirs reussis ordinateur")) {
				String[] ligne = line.split(csvPositionSeparator);
				ordinateur.getListeCaseRate().add(new Position(Integer.parseInt(ligne[0]), Integer.parseInt(ligne[1])));
			}

			// on recupere les tirs reussis du joueur ordinateur
			while (!(line = br.readLine()).matches("Tirs rates ordinateur")) {
				ordinateur.setNombreTirsReussis(Integer.parseInt(line));
			}

			// on recupere les tirs rates du joueur ordinateur
			while ((line = br.readLine()) != null) {
				ordinateur.setNombreTirsRates(Integer.parseInt(line));
			}

			battle.setOrdinateur(ordinateur);


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
