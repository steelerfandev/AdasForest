import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class AdasRoom extends JPanel implements MouseListener{
	
	private int mouseX, mouseY;
	private BufferedImage image0;
	
	public AdasRoom(){
		super();
		//PLEASE ASK AKSHATH HOW TF TO CALL MOUSECLICKED
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (mouseX > 245 && mouseX < 245 + 191 && mouseY > 216 && mouseY < 600) {
			System.out.println("O SHIT WADDUP");
			Main.addFirstForest();
			repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
