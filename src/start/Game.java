package start;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import model.NavalBattle;
import views.MainMenuView;

public class Game extends JFrame {

	public Game() {
		super("Bataille Navale");
		setPreferredSize(new Dimension(500,500));
		
		NavalBattle bn = new NavalBattle();
		MainMenuView mm = new MainMenuView(bn);
		add(mm, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Game();		
    }
	
}
