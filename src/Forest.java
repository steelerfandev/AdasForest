import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Forest extends JPanel implements MouseListener {

	private int mouseX, mouseY;

	// here are all the images and the imagearray and the imagecount
	private BufferedImage image0;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private int numImage = 0;
	private BufferedImage[] imageArray;
	private Graphics g;
	private boolean theMouseWasClicked = false;

	// image index 0: leave room
	// Image index 1: View of forest - back and next buttons - 
	// Image index 2: See sick tree and click that
	// text says "this tree appears to be sick"
	// buttons - go ask mom, go back
	// if you go ask mom, mom says "A sick tree? You should go to the library
	// and ask about it!" Image index 3
	// switch to town panel image - will be called "firstTown" - buttons over
	// library and adjacent buildings but library is the only one initialized

	// constructor
	public Forest() {
		super();

		//all the buttons
		/*JButton leaveRoom = new JButton("Leave");
		JButton forestBack = new JButton("Back");
		JButton forestNext = new JButton("Next");
		JButton sickTreeBack = new JButton("Back");
		JButton sickTreeWhat = new JButton("What? A sick tree!");
		JButton thisTreeIsSickBack = new JButton("Back");
		JButton thisTreeIsSickAskMom = new JButton("Ask Mom about it");
		JButton momBack = new JButton("Back");
		JButton momToTown = new JButton("Go into town!");*/

		super.addMouseListener(this);
		numImage = 0;
		g = imageArray[numImage].getGraphics();
		g.drawImage(imageArray[numImage], 0, 0, null);
		System.out.println("Click on the door to leave the room.");
		if(theMouseWasClicked == true){
			numImage += 1;
			g = imageArray[numImage].getGraphics();
			g.drawImage(imageArray[numImage], 0, 0, null);
			System.out.println("Click on the door to leave the room.");
		}
		
		
		
		
		
		
	
		
		

		try { // you have to do this in case it cant find the image

			// put the images into the image array
			image0 = ImageIO.read(new File("adasroom.jpg"));
			image1 = ImageIO.read(new File("adasforest.jpg"));
			image2 = ImageIO.read(new File("adastree.jpg"));
			image3 = ImageIO.read(new File("image2.jpg"));
			image4 = ImageIO.read(new File("image2.jpg"));

			// instantiate the image array so it is not null
			imageArray = new BufferedImage[5];

			// set up everything in the image array
			imageArray[0] = image0;
			imageArray[1] = image1;
			imageArray[2] = image2;
			imageArray[3] = image3;
			imageArray[4] = image4;
		} catch (Exception e) { // catch dat exception
			e.printStackTrace(); // idk what this does rly but just keep it
									// there
		}
	}

	@Override
	public void paintComponent(Graphics g) { // so you can draw the images
		super.paintComponent(g); // just call the superclass

		// paint first image
		g.drawImage(imageArray[numImage], 0, 0, null);
	}

	private void addButton(JButton b) {
		super.add(b);
	}

	public void mouseClicked(MouseEvent e) {
		
		if(numImage == 0){ //if you're on leave room
			mouseX = e.getX();
			mouseY = e.getY();
			if (mouseX > 245 && mouseX < 245 + 191 && mouseY > 216 && mouseY < 600) {
				System.out.println("O SHIT WADDUP");
				theMouseWasClicked = true;
				Main.removeAdaRoomFromPanel();
				Main.addFirstForest();
				repaint();
			}
		}
		if(numImage == 1){
			
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