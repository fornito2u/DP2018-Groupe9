package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.util.Observer;
import java.util.ArrayList;
import java.util.Observable;
import model.NavalBattle;
import model.Board;
import model.Position;
import start.Game;
import java.io.File;

public class GameView extends JPanel implements Observer {
	final public static int BUTTONSNUMBER = 10;
	private JButton[][] aIBoardButton = new JButton[10][10];
	private JButton[][] humanBoardButton = new JButton[10][10];
	private JButton shoot;
	private JLabel playerBadShootCount, playerGoodShootCount, computerBadShootCount, computerGoodShootCount;
	Position position = null;
	private Game game;
	private NavalBattle battle;
	Position currentPosition;

	public GameView(Game app, NavalBattle battle) {
		super(new BorderLayout());
		game = app;
		this.battle = battle;
		this.battle.addObserver(this);
		this.buildPanel();
	}

	private void buildPanel() { 	
		JPanel plateauxPanel = new JPanel(new GridLayout(2, 1));
		Font font = new Font(Font.DIALOG, Font.BOLD, 8);
		JPanel computerPanel = new JPanel(new GridLayout(BUTTONSNUMBER + 1, BUTTONSNUMBER + 1));
		for (int j = 0; j < BUTTONSNUMBER + 1; j++) {
			for (int i = 0; i < BUTTONSNUMBER + 1; i++) {
				if (j == 0) {
					if (i != 0) {
						JButton b = new JButton("" + (char)(i+64));
						b.setEnabled(false);
						computerPanel.add(b);
					} else {
						JButton b = new JButton();
						b.setEnabled(false);
						computerPanel.add(b);
					}
				} else {
					if (i == 0) {
						if (j != 0) {
							JButton b = new JButton("" + (j));
							b.setEnabled(false);
							b.setFont(font);
							computerPanel.add(b);
						}
					} else {
						JButton b = new JButton();
						b.addActionListener(new CustomListener(i-1, j-1));
						aIBoardButton[i-1][j-1] = b;
						computerPanel.add(b);
					}
				}
			}
		}

		JPanel playerPanel = new JPanel(new GridLayout(BUTTONSNUMBER + 1, BUTTONSNUMBER + 1));
		for (int j = 0; j < BUTTONSNUMBER + 1; j++) {
			for (int i = 0; i < BUTTONSNUMBER + 1; i++) {
				if (j == 0) {
					if (i != 0) {
						JButton b = new JButton("" + (char)(i+64));
						b.setEnabled(false);
						playerPanel.add(b);
					} else {
						JButton b = new JButton();
						b.setEnabled(false);
						playerPanel.add(b);
					}
				} else {
					if (i == 0) {
						if (j != 0) {
							JButton b = new JButton("" + (j));
							b.setFont(font);
							b.setEnabled(false);
							playerPanel.add(b);
						}
					} else {
						JButton b = new JButton();
						humanBoardButton[i-1][j-1] = b;
						b.setEnabled(false);
						playerPanel.add(b);
					}
				}
			}
		}

		plateauxPanel.add(computerPanel);
		plateauxPanel.add(playerPanel);
		this.add(plateauxPanel, BorderLayout.CENTER);
		JPanel controlPanel = new JPanel(new GridLayout(2, 1));
		JButton exit = new JButton("Quitter");
		exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(null, "Sauvegarder avant de quitter ?", "Sauvegarde", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (answer==JOptionPane.CANCEL_OPTION)
					return;
				if (answer==JOptionPane.YES_OPTION){
					String currentDirectory = System.getProperty("user.dir");

					File savesDirectory = new File(currentDirectory + "/saves");

					if (!savesDirectory.exists()) {
						savesDirectory.mkdir();
					}
					String name = (String) JOptionPane.showInputDialog(null, "Quel nom souhaitez-vous donner à la sauvegarde ?");
					battle.addSavedFileName(name);
					battle.saveGame(savesDirectory + "/" + name + ".csv");
				}
				game.switchToPanel("menu");
			}
		});

		controlPanel.add(exit);

		shoot = new JButton("Feu!");
		shoot.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {  	
				aIBoardButton[currentPosition.getX()][currentPosition.getY()].setBackground(Color.CYAN);
				battle.shoot();
				shoot.setEnabled(false);
			}
		});

		shoot.setEnabled(false);

		controlPanel.add(shoot);

		this.add(controlPanel, BorderLayout.EAST);

		JPanel informations = new JPanel(new GridLayout(1, 2));

		JPanel playerInformations = new JPanel(new GridLayout(3, 1));
		playerInformations.setBorder(BorderFactory.createLineBorder(Color.black));

		playerInformations.add(new JLabel(" Joueur "));

		playerGoodShootCount = new JLabel(" Nombre de tirs reussis : " + 0);
		playerInformations.add(playerGoodShootCount);

		playerBadShootCount = new JLabel(" Nombre de tirs rates : " + 0);		
		playerInformations.add(playerBadShootCount);

		informations.add(playerInformations);

		JPanel computerInformations = new JPanel(new GridLayout(3, 1));
		computerInformations.setBorder(BorderFactory.createLineBorder(Color.black));

		computerInformations.add(new JLabel(" Ordinateur "));

		computerGoodShootCount = new JLabel(" Nombre de tirs reussis : " + 0);
		computerInformations.add(computerGoodShootCount);

		computerBadShootCount = new JLabel(" Nombre de tirs rates : " + 0);
		computerInformations.add(computerBadShootCount);

		informations.add(computerInformations);

		this.add(informations, BorderLayout.SOUTH);

	}


	private class CustomListener implements ActionListener {
		int xCoord, yCoord;

		public CustomListener(int i, int j) {
			xCoord = i;
			yCoord = j;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (currentPosition != null
					&& aIBoardButton[currentPosition.getX()][currentPosition.getY()].getBackground().equals(Color.LIGHT_GRAY)) {

				aIBoardButton[currentPosition.getX()][currentPosition.getY()].setBackground(Color.CYAN);			
			}
			currentPosition=new Position(xCoord,yCoord);

			if(battle.isValid(currentPosition)){
				aIBoardButton[xCoord][yCoord].setBackground(Color.LIGHT_GRAY);
				shoot.setEnabled(true);
			} else {
				shoot.setEnabled(false);
			}

		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Board humanBoard = battle.getHumanPlayer().getBoard();
		ArrayList<Position> missTileListH = battle.getHumanPlayer().getMissTileList();
		for (int j = 0; j < humanBoard.LINESIZE; j++) {
			for (int i = 0; i < humanBoard.LINESIZE; i++) {
				switch (humanBoard.getValue(i, j)) {
				case -2:
					humanBoardButton[i][j].setBackground(Color.RED);
					break;
				case -1:
					humanBoardButton[i][j].setBackground(Color.ORANGE);
					break;
				case 0:
					if (missTileListH.contains(new Position(i, j)))
						humanBoardButton[i][j].setBackground(Color.BLUE);
					else
						humanBoardButton[i][j].setBackground(Color.CYAN);
					break;
				case 1:
					humanBoardButton[i][j].setBackground(Color.BLACK);
				}
			}
		}

		Board AIBoard = battle.getaIPlayer().getBoard();
		ArrayList<Position> hitTileList = battle.getaIPlayer().getHitTileList();
		ArrayList<Position> missTileList = battle.getaIPlayer().getMissTileList();
		for (int j = 0; j < humanBoard.LINESIZE; j++) {
			for (int i = 0; i < humanBoard.LINESIZE; i++) {
				if (hitTileList.contains(new Position(i, j)))
					aIBoardButton[i][j].setBackground(Color.ORANGE);
				else
					if (missTileList.contains(new Position(i, j)))
						aIBoardButton[i][j].setBackground(Color.BLUE);
					else
						aIBoardButton[i][j].setBackground(Color.CYAN);
				if(AIBoard.getValue(i, j)==-2){
					aIBoardButton[i][j].setBackground(Color.RED);
				}
			}
		}

		playerGoodShootCount.setText(" Nombre de tirs reussis : " + battle.getNbHitShot(1));
		playerBadShootCount.setText(" Nombre de tirs rates : " + battle.getNbMissShot(1));

		computerGoodShootCount.setText(" Nombre de tirs reussis : " + battle.getNbHitShot(0));
		computerBadShootCount.setText(" Nombre de tirs rates : " + battle.getNbMissShot(0));

		if (battle.gameOver()) {
			String message = battle.getCurrentPlayer() == 0 ? " Vous avez gagne ! " : " L'ordinateur a gagne ! ";
			JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);

			game.switchToPanel("menu");
		}

	}
}