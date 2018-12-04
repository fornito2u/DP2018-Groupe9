package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.NavalBattle;

public class MainMenuView extends JPanel implements Observer {

	NavalBattle bn;
	
	public MainMenuView(NavalBattle bn) {
		this.bn = bn;
		JButton newGame = new JButton("Nouvelle partie");
		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
