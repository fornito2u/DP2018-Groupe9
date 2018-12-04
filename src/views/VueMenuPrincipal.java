package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import modele.BatailleNavale;

public class VueMenuPrincipal extends JPanel implements Observer {

	BatailleNavale bn;
	
	public VueMenuPrincipal(BatailleNavale bn) {
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
