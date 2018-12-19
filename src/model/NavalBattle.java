package model;

import patternFactory.EraFactory;
import patternStrategie.Strategie;
import patternStrategie.RandomShot;
import java.util.ArrayList;
import java.util.Observable;

import java.io.File;
import patternDAO.AbstractDAOFactory;



public class NavalBattle extends Observable {

	private ArrayList<String> nomPartiesSauvegardees = new ArrayList<>();
	private AbstractDAOFactory factory;
	private AbstractDAOFactory abstractDAOFactory;
	private Position selectedTile;
	private HumanPlayer humanPlayer;
	private AIPlayer aIPlayer;
	private int currentPlayer; 
	private static int HUMANPLAYER = 0, IA = 1;


	//-----------------------------------------
	public NavalBattle(AbstractDAOFactory factory) {
		this.factory = factory;

		String currentDirectory = System.getProperty("user.dir");

		File savesDirectory = new File(currentDirectory + "/sauvegardes");

		if (savesDirectory.exists()) {
			for (File f : savesDirectory.listFiles()) {
				
				String name = f.getName().substring(0, f.getName().indexOf("."));
				nomPartiesSauvegardees.add(name);
			}
		}

	}

	

	public void createGame(EraFactory eraFactory, Strategie strat){
		ArrayList<Boat> listeBateauxHumain = eraFactory.createBoat();
		Board plateauHumain = new Board(listeBateauxHumain);
		humanPlayer = new HumanPlayer(plateauHumain, listeBateauxHumain);
		
		ArrayList<Boat> listeBateauxOrdi = eraFactory.createBoat();
		Board plateauOrdinateur = new Board(listeBateauxOrdi);
		aIPlayer = new AIPlayer(plateauOrdinateur, listeBateauxOrdi, strat);
		currentPlayer = HUMANPLAYER;
		
		setChanged();
		notifyObservers();
		
	}

	public void stockSelectedTile(Position p){}
	
	public void shoot(){}
	
	public boolean isValid(Position p){
		boolean answer = false;
		return answer;
	}

	public void changeCurrentPlayer(){}

	public void saveGame(){}

	public void loadGame(String name){}



	public ArrayList<String> getNomPartiesSauvegardees() {
		return nomPartiesSauvegardees;
	}



	public void setNomPartiesSauvegardees(ArrayList<String> nomPartiesSauvegardees) {
		this.nomPartiesSauvegardees = nomPartiesSauvegardees;
	}



	public AbstractDAOFactory getFactory() {
		return factory;
	}



	public void setFactory(AbstractDAOFactory factory) {
		this.factory = factory;
	}



	public AbstractDAOFactory getAbstractDAOFactory() {
		return abstractDAOFactory;
	}



	public void setAbstractDAOFactory(AbstractDAOFactory abstractDAOFactory) {
		this.abstractDAOFactory = abstractDAOFactory;
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



	public static void setHUMANPLAYER(int hUMANPLAYER) {
		HUMANPLAYER = hUMANPLAYER;
	}



	public static int getIA() {
		return IA;
	}



	public static void setIA(int iA) {
		IA = iA;
	}

	

}
