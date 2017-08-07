import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AdaRoom extends JPanel implements MouseListener {

	private int mouseX, mouseY;
	private BufferedImage adasroom;
	private BufferedImage adashouseinterior;
	private BufferedImage adashouseexterior;
	private BufferedImage imageArray[];
	private int numImage = 0;
	
	private String theMouseWasClicked = "";

	public AdaRoom (){
			super();
			
			imageArray = new BufferedImage[3];
			
			super.addMouseListener(this);
			repaint();
			System.out.println("Click on the door to leave the room.");
			if(theMouseWasClicked.equals("left room")){
				numImage ++;
				repaint();
				System.out.println("Click on the door on the left to go outside.");
				System.out.println("Click on the door on the right to go back to your room.");
				if(theMouseWasClicked.equals("go outside")){
					numImage ++;
					repaint();
				}
				else if(theMouseWasClicked.equals("go to room")){
				numImage--;
				repaint();
					System.out.println("Click on the door to leave the room.");
					//hard coded recursiveness
					if(theMouseWasClicked.equals("left room")){
						numImage ++;
						System.out.println("Click on the door on the left to go outside.");
						System.out.println("Click on the door on the right to go back to your room.");
						repaint();
						if(theMouseWasClicked.equals("go outside")){
							numImage ++;
							repaint();
						}
						else if(theMouseWasClicked.equals("go to room")){
						numImage--;
						repaint();
							System.out.println("Click on the door to leave the room.");
						}
					}
				}
			}
			
			//the image
			try{
				adasroom=ImageIO.read(new File("adasroom.jpg"));
				adashouseinterior=ImageIO.read(new File("adashouseinterior.jpg"));
				adashouseexterior=ImageIO.read(new File("adashouseexterior.jpg"));
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			imageArray[0]= adasroom;
			imageArray[1] = adashouseinterior;
			imageArray[2] = adashouseexterior;
		}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(imageArray[numImage], 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		System.out.println(mouseX);
		System.out.println(mouseY);
		System.out.println(numImage);
		if(numImage == 0){
			if (mouseX > 245 && mouseX < 245 + 191 && mouseY > 216 && mouseY < 600) {
				theMouseWasClicked = "left room";
				repaint();
			}
		}
		else if(numImage == 1){
			
			//CHANGE INTO GRAPHICS FOR HOUSE INTERIOR
			//COORDINATES FOR LEFT DOOR
			if (mouseX > 0 && mouseX < 132 && mouseY > 236 && mouseY < 600) {
				theMouseWasClicked = "go outside";
				repaint();
			}
			//COORDINATES FOR RIGHT DOOR
			if (mouseX > 651 && mouseX < 800 && mouseY > 241 && mouseY < 600) {
				theMouseWasClicked = "go to room";
				repaint();
			}
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
