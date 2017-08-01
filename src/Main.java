import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {
	public static void main(String[] args){
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){
			
		}
		
		JFrame frame = new JFrame("Ada's Forest"); //TITLE
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this closes the panel when I click the x
		frame.setSize(800, 600); //sets the size of window
		frame.setVisible(true); //sets window visible
		
		MyCustomPanel panel = new MyCustomPanel();
		
		frame.add(panel);
		frame.setVisible(true);
		
		if(panel.buttonClicked == true){
			frame.remove(panel);
			frame.setVisible(false);
		}
		//jkhfkhfjhgjl
		
	}
}
