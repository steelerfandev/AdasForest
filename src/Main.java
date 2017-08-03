import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {
	
	private static HomeScreen homescreen;
	private static ExpositionCutScene expscene;
	public static JFrame frame;
	public static int numImage;
	private static FirstForest firstForest;
	private static FirstTown firstTown;
	private static FirstLibrary firstLibrary;
	
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
	
	public static void removeExpSceneFromPanel(){
		expscene.setVisible(false);
	}
	
	public static void removeFirstForestFromPanel(){
		firstForest.setVisible(false);
	}
	
	public static void removeFirstTownFromPanel(){
		firstForest.setVisible(false);
	}
	
	
	
	public static void addExpScene(){
		expscene = new ExpositionCutScene();
		
		frame.add(expscene);
		frame.setVisible(true);
	}
	
	public static void addFirstForest(){
		firstForest = new FirstForest();
		
		frame.add(firstForest);
		frame.setVisible(true);
	}
	
	public static void addFirstTown(){
		firstTown = new FirstTown();
		
		frame.add(firstTown);
		frame.setVisible(true);
	}
	
	public static void addFirstLibrary(){
		firstLibrary = new FirstLibrary();
		
		frame.add(firstLibrary); //this error gets fixed when you instantiate the constructor for firstlibrary
		frame.setVisible(true);
	}
	
	
}
