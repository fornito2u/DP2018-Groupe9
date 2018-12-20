package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.io.File;

import start.Game;

public class MainMenuView extends JPanel {
    private Game game;

    private JButton newGameButton, savedGameButton;

    public MainMenuView(Game g) {
        game = g;
        buildPanel();
    }
    
    private void buildPanel() {
        this.setLayout(new GridLayout(1, 2));

        newGameButton = new JButton("Nouvelle partie");
        newGameButton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                game.switchToPanel("newGame");
            }
        });

        this.add(newGameButton);

        // Defining a button to continue a previous game
        savedGameButton = new JButton("Reprendre une partie");
        savedGameButton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentDirectory = System.getProperty("user.dir");

                File savesDirectory = new File(currentDirectory + "/saves");

                if (!savesDirectory.exists() || (savesDirectory.listFiles().length == 0)) {
                    JOptionPane.showMessageDialog(null, "Il n'y a aucune sauvegarde actuellement", "Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    game.switchToPanel("resumeGame");
                }
            }
        });

        this.add(savedGameButton);
    }

}