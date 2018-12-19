package patternDAO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.NavalBattle;
import model.Boat;
import model.Board;
import model.Position;


public class CsvWriter {
	
	public CsvWriter(NavalBattle battle, String fileName) {
		generateCsvFile(battle, fileName);
	}
	
	private static void generateCsvFile(NavalBattle battle, String fileName) {
		try {
			FileWriter writer = new FileWriter(fileName);
			String csvSeparator = "#";
			
		
			writer.append(battle.getCurrentPlayer() + "\n");
			
		
			writer.append("Plateau joueur humain\n");
			Board humanBoard = battle.getHumanPlayer().getBoard();
			for (int j = 0; j < humanBoard.LINESIZE; j++) {
				for (int i = 0; i < humanBoard.LINESIZE; i++) {
					writer.append("" + humanBoard.getValue(i, j));
					writer.append(csvSeparator);
				}
				writer.append("\n");
			}
			
			writer.append("Bateaux humain\n");
			ArrayList<Boat> bateauHumain = battle.getHumanPlayer().getBoatList();
			for (Boat b : bateauHumain) {
				writer.append(b.getHealth() + " , " + b.getSize() + " , " + b.getPosX() + " , " + b.getPosY() + " , " + b.getOrientation() + "\n");
			}
			
			// liste des cases touchees par le joueur ordinateur		
			writer.append("Cases touchees ordinateur\n");
			ArrayList<Position> listeCaseToucheeHumain = battle.getHumanPlayer().getHitTileList();
			for (Position p : listeCaseToucheeHumain) {
				writer.append(p.getX() + " , " + p.getY() + "\n");
			}
			
			// liste des cases ratees par le joueur ordinateur						
			writer.append("Cases ratees ordinateur\n");
			ArrayList<Position> listeCaseRateeHumain = battle.getHumanPlayer().getMissedTileList();
			for (Position p : listeCaseRateeHumain) {
				writer.append(p.getX() + " , " + p.getY() + "\n");
			}
			
			// compteur tirs reussis pour le joueur humain
			writer.append("Tirs reussis humain\n");
			writer.append(battle.getHumanPlayer().getNbHitShot() + "\n");

			// compteur tirs rates pour le joueur humain
			writer.append("Tirs rates humain\n");
			writer.append(battle.getHumanPlayer().getNbMissShot() + "\n");
			
			// plateau du joueur ordinateur
			writer.append("Plateau joueur ordinateur\n");
			Plateau plateauOrdinateur = battle.getOrdinateur().getPlateau();				
			for (int j = 0; j < plateauOrdinateur.LINESIZE; j++) {
				for (int i = 0; i < plateauOrdinateur.LINESIZE; i++) {					
					writer.append("" + plateauOrdinateur.getValeur(i, j));
					writer.append(csvSeparator);
				}
				writer.append("\n");
			}
			
			// liste des bateaux pour le joueur ordinateur
			writer.append("Bateaux ordinateur\n");
			ArrayList<Bateau> bateauOrdi = battle.getOrdinateur().getListeBateau();
			for (Bateau b : bateauOrdi) {
				writer.append(b.getHealth() + " , " + b.getSize() + " , " + b.getPosX() + " , " + b.getPosY() + " , " + b.getOrientation() + "\n");
			}
			
			// strategie du joueur ordinateur
			writer.append("Strategie ordinateur\n");
			writer.append(battle.getOrdinateur().getStrategie() + "\n");
			
			// liste des cases touchees par le joueur humain
			writer.append("Cases touchees humain\n");
			ArrayList<Position> listeCaseToucheeOrdi = battle.getOrdinateur().getListeCaseTouche();
			for (Position p : listeCaseToucheeOrdi) {
				writer.append(p.getX() + " , " + p.getY() + "\n");
			}

			// liste des cases ratees par le joueur humain	
			writer.append("Cases ratees humain\n");
			ArrayList<Position> listeCaseRateeOrdi = battle.getOrdinateur().getListeCaseRate();
			for (Position p : listeCaseRateeOrdi) {
				writer.append(p.getX() + " , " + p.getY() + "\n");
			}
			
			// compteur tirs reussis pour le joueur ordinateur
			writer.append("Tirs reussis ordinateur\n");
			writer.append(battle.getOrdinateur().getNombreTirsReussis() + "\n");

			// compteur tirs rates pour le joueur ordinateur
			writer.append("Tirs rates ordinateur\n");
			writer.append(battle.getOrdinateur().getNombreTirsRates() + "\n");
		
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
