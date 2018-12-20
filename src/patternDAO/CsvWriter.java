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
			
			writer.append("Cases touchees ordinateur\n");
			ArrayList<Position> listeCaseToucheeHumain = battle.getHumanPlayer().getHitTileList();
			for (Position p : listeCaseToucheeHumain) {
				writer.append(p.getX() + " , " + p.getY() + "\n");
			}
							
			writer.append("Cases ratees ordinateur\n");
			ArrayList<Position> listeCaseRateeHumain = battle.getHumanPlayer().getMissTileList();
			for (Position p : listeCaseRateeHumain) {
				writer.append(p.getX() + " , " + p.getY() + "\n");
			}
			
			writer.append("Tirs reussis humain\n");
			writer.append(battle.getHumanPlayer().getNbHitShot() + "\n");

			writer.append("Tirs rates humain\n");
			writer.append(battle.getHumanPlayer().getNbMissShot() + "\n");
			
			writer.append("Plateau joueur ordinateur\n");
			Board plateauOrdinateur = battle.getaIPlayer().getBoard();				
			for (int j = 0; j < plateauOrdinateur.LINESIZE; j++) {
				for (int i = 0; i < plateauOrdinateur.LINESIZE; i++) {					
					writer.append("" + plateauOrdinateur.getValue(i, j));
					writer.append(csvSeparator);
				}
				writer.append("\n");
			}
			
			writer.append("Bateaux ordinateur\n");
			ArrayList<Boat> bateauOrdi = battle.getaIPlayer().getBoatList();
			for (Boat b : bateauOrdi) {
				writer.append(b.getHealth() + " , " + b.getSize() + " , " + b.getPosX() + " , " + b.getPosY() + " , " + b.getOrientation() + "\n");
			}
			
			writer.append("Strategie ordinateur\n");
			writer.append(battle.getaIPlayer().getStrategie() + "\n");
			
			writer.append("Cases touchees humain\n");
			ArrayList<Position> listeCaseToucheeOrdi = battle.getaIPlayer().getHitTileList();
			for (Position p : listeCaseToucheeOrdi) {
				writer.append(p.getX() + " , " + p.getY() + "\n");
			}

			writer.append("Cases ratees humain\n");
			ArrayList<Position> listeCaseRateeOrdi = battle.getaIPlayer().getMissTileList();
			for (Position p : listeCaseRateeOrdi) {
				writer.append(p.getX() + " , " + p.getY() + "\n");
			}
			
			writer.append("Tirs reussis ordinateur\n");
			writer.append(battle.getaIPlayer().getNbHitShot() + "\n");

			writer.append("Tirs rates ordinateur\n");
			writer.append(battle.getaIPlayer().getNbMissShot() + "\n");
		
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
