import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AdasRoom extends JPanel implements MouseListener{
	
	private int mouseX, mouseY;
	private BufferedImage image;
	
	public AdasRoom(){
		super();
		
		super.addMouseListener(this);
		//ACTUALLY HOW TF DOES MOUSECLICKED WORK
		
		//the image
		try{
			image=ImageIO.read(new File("adasroom.jpg"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
