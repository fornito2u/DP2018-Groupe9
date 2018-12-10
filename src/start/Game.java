package start;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import model.NavalBattle;
import views.GameView;
import views.LoadMenuView;
import views.MainMenuView;
import views.NewGameView;

public class Game extends JFrame {

	private CardLayout cl;
	private MainMenuView mmv;
	private LoadMenuView lmv;
	private NewGameView ngv;
	private GameView gv;
	
	public Game() {
		super("Bataille Navale");
		setPreferredSize(new Dimension(500,500));
		cl = new CardLayout();
		
		NavalBattle nb = new NavalBattle();
		mmv = new MainMenuView(nb, this);
		lmv = new LoadMenuView(nb, this);
		ngv = new NewGameView(nb, this);
		gv = new GameView(nb, this);
		add(mmv, cl);
		add(lmv, cl);
		add(ngv, cl);
		add(ngv, cl);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public void changeView(String viewName){
		switch (viewName){
		case "game":
			cl.show(this,gv.getName());
			break;
		case "loadMenu" :
			cl.show(this,lmv.getName());
			break;
		case "mainMenu":
			cl.show(this,mmv.getName());
			break;
		case "newGame":
			cl.show(this,ngv.getName());
			break;
		}
	}
	
	public static void main(String[] args) {
		new Game();		
    }
	
}
