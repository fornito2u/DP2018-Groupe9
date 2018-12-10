package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import start.Game;

import model.NavalBattle;

public class MainMenuView extends JPanel implements Observer {

	private NavalBattle nb;
	private Game game;
	private String name = "mainMenu";
	
	public MainMenuView(NavalBattle nb, Game g) {
		this.nb = nb;
		this.game = g;
		setPreferredSize(new Dimension(100,100));
		setLayout(new GridLayout(4,4));
		JButton newGame = new JButton("Nouvelle partie");
		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				game.changeView(name);
			}
			
		});
		JButton loadGame = new JButton("Charger une partie");
		loadGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.add(newGame);
		this.add(loadGame);
	}
	
	
	
	public String getName() {
		return name;
	}



	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
