package model;

import patternFactory.EraFactory;
import patternStrategie.Strategie;
import patternStrategie.RandomShot;
import java.util.ArrayList;
import java.util.Observable;
import java.io.File;
import patternDAO.AbstractDAOFactory;



public class NavalBattle extends Observable {

	private Position selectedTile;
	private AIPlayer aIPlayer;
	private HumanPlayer humanPlayer;
	private int currentPlayer; 
	private static int HUMANPLAYER = 0, AI = 1;
	private ArrayList<String> SavedFileName = new ArrayList<>();
	private AbstractDAOFactory factory;

	public NavalBattle(AbstractDAOFactory factory) {
		this.factory = factory;

		String currentDirectory = System.getProperty("user.dir");

		File savesDirectory = new File(currentDirectory + "/sauvegardes");

		if (savesDirectory.exists()) {
			for (File f : savesDirectory.listFiles()) {
				
				String name = f.getName().substring(0, f.getName().indexOf("."));
				SavedFileName.add(name);
			}
		}

	}

	

	public void createGame(EraFactory eraFactory, Strategie strat){
		ArrayList<Boat> humanBoatList = eraFactory.createBoat();
		Board plateauHumain = new Board(humanBoatList);
		humanPlayer = new HumanPlayer(plateauHumain, humanBoatList);
		
		ArrayList<Boat> aIBoatList = eraFactory.createBoat();
		Board aIBoard = new Board(aIBoatList);
		aIPlayer = new AIPlayer(aIBoard, aIBoatList, strat);
		currentPlayer = HUMANPLAYER;
		
		setChanged();
		notifyObservers();
		
	}

	public void stockSelectedTile(Position p){
		selectedTile = p;
	}
	
	public void shoot(){
		if (currentPlayer == HUMANPLAYER) {
			aIPlayer.gettingShot(selectedTile);
			if (!aIPlayer.lost()) {
				changeCurrentPlayer();
				setChanged();
				notifyObservers();
				shoot();
			} else {
				setChanged();
				notifyObservers();
			}
		} else {
			Position p = aIPlayer.getShotPosition(humanPlayer.getHitTileList(), humanPlayer.getMissTileList());
			humanPlayer.gettingShot(p);
			if (!humanPlayer.lost()) {
				changeCurrentPlayer();
				setChanged();
				notifyObservers();
			} else {
				setChanged();
				notifyObservers();
			}
		}
	}
	
	public void changeCurrentPlayer(){
		if (currentPlayer == HUMANPLAYER)
			currentPlayer = AI;
		else
			currentPlayer = HUMANPLAYER;
		
	}
	
	public boolean isValid(Position p){
		boolean valide = false;

		if (currentPlayer == HUMANPLAYER) {	
	       
			valide = !aIPlayer.tileTouched(p);
		}
		
		if (valide)
			stockSelectedTile(p);
		
		return valide;
	}

	
	public boolean gameOver() {
		return (aIPlayer.lost() || humanPlayer.lost());
	}

	public void saveGame(String fileName){
		factory.getBattleDAO().saveGame(this, fileName);
	}

	public void loadGame(String fileName){
		NavalBattle battle = factory.getBattleDAO().loadGame(fileName);
		this.humanPlayer = battle.getHumanPlayer();
		this.aIPlayer = battle.getaIPlayer();
		this.currentPlayer = battle.getCurrentPlayer();
		
		setChanged();
		notifyObservers();
	}

	
	//--------------------------------------------------------------------------------------------------
	//-----------------------------------------GETTER & SETTER/-----------------------------------------
	//--------------------------------------------------------------------------------------------------
	
	

	public ArrayList<String> getSavedFileName() {
		return SavedFileName;
	}



	public void setSavedFileName(ArrayList<String> SavedFileName) {
		this.SavedFileName = SavedFileName;
	}



	public AbstractDAOFactory getFactory() {
		return factory;
	}



	public void setFactory(AbstractDAOFactory factory) {
		this.factory = factory;
	}


	public Position getSelectedTile() {
		return selectedTile;
	}



	public void setSelectedTile(Position selectedTile) {
		this.selectedTile = selectedTile;
	}



	public HumanPlayer getHumanPlayer() {
		return humanPlayer;
	}



	public void setHumanPlayer(HumanPlayer humanPlayer) {
		this.humanPlayer = humanPlayer;
	}



	public AIPlayer getaIPlayer() {
		return aIPlayer;
	}



	public void setaIPlayer(AIPlayer aIPlayer) {
		this.aIPlayer = aIPlayer;
	}



	public int getCurrentPlayer() {
		return currentPlayer;
	}



	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}



	public static int getHUMANPLAYER() {
		return HUMANPLAYER;
	}



	public static void setHUMANPLAYER(int humanplayer) {
		HUMANPLAYER = humanplayer;
	}



	public static int getIA() {
		return AI;
	}



	public static void setIA(int ai) {
		AI = ai;
	}

	

}
