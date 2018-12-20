package views;

import java.awt.GridLayout;

import java.io.File;

import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.NavalBattle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import start.Game;

public class LoadMenuView extends JPanel implements Observer {

    private Game game;

    private JButton playButton;
    private JList savedGamesList;
    
    private NavalBattle battle;

    public LoadMenuView(Game g, NavalBattle nb) {
        game = g ;
        battle = nb;
        buildPanel();

        battle.addObserver(this);
    }

    private void buildPanel() {
        this.setLayout(new GridLayout(2, 1));

        String currentDirectory = System.getProperty("user.dir");

        File savesDirectory = new File(currentDirectory + "/saves");

        ArrayList<String> names = new ArrayList<>();
        if (savesDirectory.exists()) {
            for (File f : savesDirectory.listFiles()) {
                String name = f.getName().substring(0, f.getName().indexOf("."));
                names.add(name);
            }
        }
        
        savedGamesList = new JList<>(names.toArray());

        savedGamesList.addListSelectionListener(new ListSelectionListener(){
        
            @Override
            public void valueChanged(ListSelectionEvent e) {
                playButton.setEnabled(true);
            }
        });

        this.add(savedGamesList);

        JPanel buttons = new JPanel(new GridLayout(2, 1));

        playButton = new JButton("Jouer");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = (String)savedGamesList.getSelectedValue();
                battle.loadGame(System.getProperty("user.dir") + "/saves/" + name + ".csv");

                savedGamesList.clearSelection();
                playButton.setEnabled(false);             
                game.switchToPanel("jeu");
            }
        });

        playButton.setEnabled(false);

        buttons.add(playButton);

        JButton previous = new JButton("Retour");
        previous.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                game.switchToPanel("menu");
            }
        });

        buttons.add(previous);

        this.add(buttons);
    }

    @Override
	public void update(Observable arg0, Object arg1) {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < battle.getSavedFileNameSize(); i++) {
            names.add(battle.getSavedFileName(i));
        }

        savedGamesList.setListData(names.toArray());
	}
    
}