package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.event.ListSelectionListener;
import javax.swing.SwingConstants;

import patternFactory.EraFactory;
import patternFactory.EraXVI;
import patternFactory.EraXX;
import model.NavalBattle;
import patternStrategie.Strategie;
import patternStrategie.RandomShot;
import patternStrategie.CrossShot;

import javax.swing.event.ListSelectionEvent;

import start.Game;

public class NewGameView extends JPanel {
    final private static String[] eras = {"EpoqueXVI", "EpoqueXX"};
    final private static String[] strategies = {"Tir aleatoire", "Tir en croix"};

    private Game game;

    private JList eraList, strategyList;
    private JButton playButton;
    private NavalBattle battle;

    public NewGameView(Game g, NavalBattle nb){
        game = g;
        battle = nb;
        this.buildPanel();
        
    }

    private void buildPanel() {
        this.setLayout(new GridLayout(2, 1));

        JPanel lists = new JPanel(new GridLayout(2, 2));

        JLabel eraLabel = new JLabel("Epoques");
        eraLabel.setHorizontalAlignment(SwingConstants.CENTER);
        eraLabel.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel strategiesLabel = new JLabel("Strategies");
        strategiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        strategiesLabel.setBorder(BorderFactory.createLineBorder(Color.black));        

        lists.add(eraLabel);
        lists.add(strategiesLabel);

        eraList = new JList<String>(eras);
        eraList.setBorder(BorderFactory.createLineBorder(Color.black));
        eraList.addListSelectionListener(new ListSelectionListener(){
        
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!strategyList.isSelectionEmpty())
                    playButton.setEnabled(true);
                }
        });
        lists.add(eraList);

        strategyList = new JList<String>(strategies);
        strategyList.setBorder(BorderFactory.createLineBorder(Color.black));        
        strategyList.addListSelectionListener(new ListSelectionListener(){
        
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!eraList.isSelectionEmpty())
                    playButton.setEnabled(true);
                }
        });
        lists.add(strategyList);

        this.add(lists);

        JPanel buttons = new JPanel(new GridLayout(2, 1));

        playButton = new JButton("Jouer");
        playButton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                EraFactory era = null;
                Strategie strategy = null;
             
                String eraListValue = (String)eraList.getSelectedValue();
                if (eraListValue == eras[0]) {
                    era = new EraXVI();
                } else if (eraListValue == eras[1]) {
                    era = new EraXX();
                }

                String strategyListValue = (String)strategyList.getSelectedValue();
                if (strategyListValue == strategies[0]) {
                    strategy = new RandomShot();
                } else if (strategyListValue == strategies[1]) {
                    strategy = new CrossShot();
                }

                battle.createGame(era, strategy);

            	/*******************************************************/
            	
                eraList.clearSelection();
                strategyList.clearSelection();
                playButton.setEnabled(false);
                game.switchToPanel("game");
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
}