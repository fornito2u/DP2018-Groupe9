package start;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import model.NavalBattle;
import patternStrategie.RandomShot;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import patternDAO.AbstractDAOFactory;
import patternFactory.EraXVI;
import views.*;

public class Game extends JFrame {

	  private CardLayout cardLayout;
	  private JPanel mainPanel;
	    
	public Game() {
		super("Bataille Navale");
        NavalBattle battle = new NavalBattle(AbstractDAOFactory.getAbstractDAOFactory());
        this.buildFrame(battle);
	}
	
	private void buildFrame(NavalBattle battle) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 500));
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        this.mainPanel.add(new MainMenuView(this), "menu");
        this.mainPanel.add(new NewGameView(this,battle), "newGame");
        this.mainPanel.add(new GameView(this, battle), "game");
        this.mainPanel.add(new LoadGameView(this, battle), "resumeGame");            
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
	}
	
	public void switchToPanel(String panelName) {
        switch (panelName) {
            case "menu" :
                cardLayout.show(mainPanel, "menu");
                break;
            case "newGame" :
                cardLayout.show(mainPanel, "newGame");
                break;
            case "resumeGame" :
                cardLayout.show(mainPanel, "resumeGame");
                break;
            case "game" :
                cardLayout.show(mainPanel, "game");
        }
    }
	
	public static void main(String[] args) {
		new Game();		
    }
	
}
