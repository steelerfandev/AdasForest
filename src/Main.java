import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {
	
	private static HomeScreen homescreen;
	private static ExpositionCutScene expscene;
	public static JFrame frame;
	public static int numImage;
	
	public static void main(String[] args){
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){
			
		}
		
		frame = new JFrame("Ada's Forest"); //TITLE
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this closes the panel when I click the x
		frame.setSize(800, 600); //sets the size of window
		
		homescreen = new HomeScreen();
		
		frame.add(homescreen);
		frame.setVisible(true);
	}
	
	public static void removeHomeScreenFromPanel(){
		homescreen.setVisible(false);
	}
	
	public static void addExpScene(){
		expscene = new ExpositionCutScene();
		
		frame.add(expscene);
		frame.setVisible(true);
	}
}
