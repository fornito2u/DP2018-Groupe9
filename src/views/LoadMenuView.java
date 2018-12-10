package views;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import start.Game;

import model.NavalBattle;

public class LoadMenuView extends JPanel implements Observer {

	private Game game;
	private NavalBattle nb;
	private String name = "loadMenu";
	
	public LoadMenuView(NavalBattle nb, Game g){
		this.nb = nb;
		this.game = g;
	}
	
	
	
	public String getName() {
		return name;
	}



	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
