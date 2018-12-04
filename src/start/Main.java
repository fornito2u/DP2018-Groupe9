package start;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import modele.BatailleNavale;
import views.MainMenu;

public class Main extends JFrame {

	public Main() {
		super("Bataille Navale");
		setPreferredSize(new Dimension(500,500));
		
		BatailleNavale bn = new BatailleNavale();
		MainMenu mm = new MainMenu(bn);
		add(mm, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();		
    }
	
}
