package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

import start.Game;

import model.NavalBattle;

public class NewGameView extends JPanel implements Observer{

	private Game game;
	private NavalBattle nb;
	private String name = "newGame";
	
	public NewGameView(NavalBattle nb, Game g){
		this.nb = nb;
		this.game = g;
		
		GridLayout gl = new GridLayout(0,2);
		setLayout(gl);
		
		JLabel labelEra = new JLabel("Choisissez l'époque de la bataille");
		JRadioButtonMenuItem menuEra = new JRadioButtonMenuItem();
		JRadioButton twentyEra = new JRadioButton("XXe siècle");
		JRadioButton sixteenEra = new JRadioButton("XVIe siècle");
		menuEra.add(twentyEra);
		menuEra.add(sixteenEra);
		
		JLabel labelStrategie = new JLabel("Choisissez la stratégie adoptée par l'IA");
		JRadioButtonMenuItem menuStrategie = new JRadioButtonMenuItem();
		JRadioButton cross = new JRadioButton("En croix");
		JRadioButton random = new JRadioButton("Aléatoire");
		menuEra.add(cross);
		menuEra.add(random);
		
		add(labelEra);
		add(labelStrategie);
		add(menuEra);
		add(menuStrategie);
						
		JButton lauchGame = new JButton("Lancer la partie");
		lauchGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				game.changeView(name);
			}
			
		});
		
		add(lauchGame);
		
	}
	
	
	
	public String getName() {
		return name;
	}



	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
