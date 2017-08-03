import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.*;

public class ExpositionCutScene extends JPanel implements MouseMotionListener {

	//here are all the images and the imagearray and the imagecount
	private BufferedImage image0;
	private BufferedImage image1;
	private BufferedImage image2;
	private int numImage = 0;
	private BufferedImage[] imageArray;

	// Image index 0: Ada playing in her room
	// Image index 1: Ada's mom saying "Ada!"
	// Image index 2: "I'm having friends over for dinner. Go into the forest
	// and play!"
	// then you say new objective play in forest in the console

	//constructor
	public ExpositionCutScene() {
		
		//define the buttons
		JButton backButton = new JButton("Back");
		backButton.setVisible(false);
		JButton forwardButton = new JButton("Next");
		
		//size of the button
		backButton.setPreferredSize(new Dimension(90, 40));
		
		//do the onclick listener
		backButton.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { //on click
				numImage--; //down the image count
				repaint(); //repaint the image
				
				//if numImage <= 0, then hide this button
				if(numImage <= 0){
					backButton.setVisible(false);
				}
				//if numImage < 2, then show the forward button
				if(numImage <= 2){
					forwardButton.setVisible(true);
				}

			}
		});
		super.add(backButton); // this adds the button to the panel
		super.addMouseMotionListener(this); // adds the mouse motion listener to
											// the panel

		// set the size of the forward button
		forwardButton.setPreferredSize(new Dimension(90, 40));

		//get the onclick listener
		forwardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { //on click
				numImage++; //up the image count
				repaint(); //repaint
				
				//if numimage >= 2, then we're going to hide this button
				if(numImage >= 2){
					forwardButton.setVisible(false);
				}
				//if numimage > 0, then we're going to show the back button
				if(numImage >= 0){
					backButton.setVisible(true);
				}
			}
		});
		super.add(forwardButton); // this adds the button to the panel
		super.addMouseMotionListener(this); // adds the mouse motion listener to
											// the panel

		try { //you have to do this in case it cant find the image
			
			//put the images into the image array
			image0 = ImageIO.read(new File("adaforest1.jpg"));
			image1 = ImageIO.read(new File("adaforest2.jpg"));
			image2 = ImageIO.read(new File("adaforest3.jpg"));
			
			//instantiate the image array so it is not null
			imageArray = new BufferedImage[3];
			
			//set up everything in the image array
			imageArray[0] = image0;
			imageArray[1] = image1;
			imageArray[2] = image2;
		} catch (Exception e) {  //catch dat exception
			e.printStackTrace(); //idk what this does rly but just keep it there
		}


	}

	@Override
	public void paintComponent(Graphics g){ //so you can draw the images
		super.paintComponent(g); //just call the superclass
		
		//paint first image
		g.drawImage(imageArray[numImage], 0, 0, null);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
