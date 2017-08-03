import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FirstForest extends JPanel {
	// here are all the images and the imagearray and the imagecount
	private BufferedImage image0;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private int numImage = 0;
	private BufferedImage[] imageArray;

	// image index 0: leave room
	// Image index 1: View of forest - back and next buttons
	// Image index 2: See sick tree and click that
	// text says "this tree appears to be sick"
	// buttons - go ask mom, go back
	// if you go ask mom, mom says "A sick tree? You should go to the library
	// and ask about it!" Image index 3
	// switch to town panel image - will be called "firstTown" - buttons over
	// library and adjacent buildings but library is the only one initialized

	// constructor
	public FirstForest() {

		JButton leaveRoom = new JButton("Leave");
		JButton forestBack = new JButton("Back");
		JButton forestNext = new JButton("Next");
		JButton sickTreeBack = new JButton("Back");
		JButton sickTreeWhat = new JButton("What? A sick tree!");
		JButton thisTreeIsSickBack = new JButton("Back");
		JButton thisTreeIsSickAskMom = new JButton("Ask Mom about it");
		JButton momBack = new JButton("Back");
		JButton momToTown = new JButton("Go into town!");

		leaveRoom.setPreferredSize(new Dimension(120, 40));
		addButton(leaveRoom); // this adds the button to the panel

		// do the onclick listener
		leaveRoom.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage++;
				leaveRoom.setVisible(false);
				forestBack.setVisible(true);
				forestNext.setVisible(true);
				repaint();

				if (numImage == 1) {
					addButton(forestBack); // this adds the button to the panel
					addButton(forestNext);
				}
			}
		});
		
		//the following is pseudocode for allowing the user to click on the door instead of a button
		//i had to go so i didnt have enough time to figure out how to implement
		//see if you can ask the king about it :P
		/*
		 * if(mouse clicked){
		 * if(mouseX>doorminX && mouseX<doormaxX && mouseY>doorminY && mouseY<doormaxY){
		 * forestBack.setVisible(true);
		 * etc etc
		 * repaint();
		 * }
		 * }
		 */

		forestBack.setPreferredSize(new Dimension(90, 40));

		// do the onclick listener
		forestBack.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage--;
				forestBack.setVisible(false);
				forestNext.setVisible(false);
				repaint();
				
				if (numImage == 2) {
					addButton(sickTreeBack);
				}

			}
		});

		forestNext.setPreferredSize(new Dimension(90, 40));

		// do the onclick listener
		forestNext.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage++;
				forestBack.setVisible(false);
				forestNext.setVisible(false);
				repaint();
				
				if (numImage == 2) {
					addButton(sickTreeBack);
					addButton(sickTreeWhat);
				}
			}
		});
		
		sickTreeBack.setPreferredSize(new Dimension(90, 40));

		// do the onclick listener
		sickTreeBack.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage--;
				sickTreeBack.setVisible(false);
				sickTreeWhat.setVisible(false);
				repaint();
			}
		});
		
		sickTreeWhat.setPreferredSize(new Dimension(150, 40));

		// do the onclick listener
		sickTreeWhat.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage++;
				sickTreeBack.setVisible(false);
				sickTreeWhat.setVisible(false);
				repaint();
				
				if (numImage == 3) {
					addButton(thisTreeIsSickBack);
					addButton(thisTreeIsSickAskMom);
					System.out.println("New objective: Go home and ask Mom about the tree");
				}
			}
		});
		
		thisTreeIsSickBack.setPreferredSize(new Dimension(90, 40));

		// do the onclick listener
		thisTreeIsSickBack.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage--;
				thisTreeIsSickBack.setVisible(false);
				thisTreeIsSickAskMom.setVisible(false);
				repaint();
			}
		});
		
		thisTreeIsSickAskMom.setPreferredSize(new Dimension(150, 40));

		// do the onclick listener
		thisTreeIsSickAskMom.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage++;
				thisTreeIsSickBack.setVisible(false);
				thisTreeIsSickAskMom.setVisible(false);
				repaint();
				
				if (numImage == 4) {
					addButton(momBack);
					addButton(momToTown);
				}
			}
			
		});
		
		momBack.setPreferredSize(new Dimension(90, 40));

		// do the onclick listener
		momBack.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage--;
				momBack.setVisible(false);
				momToTown.setVisible(false);
				repaint();
			}
		});
		
		momToTown.setPreferredSize(new Dimension(150, 40));

		// do the onclick listener
		momToTown.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage++;
				momBack.setVisible(false);
				momToTown.setVisible(false);
				repaint();
				
				if (numImage == 5) {
					Main.removeFirstForestFromPanel();
					Main.addFirstTown();
					System.out.println("New objective: Go to the library!");
					return;
				}
			}
		});

		try { // you have to do this in case it cant find the image

			// put the images into the image array
			image0 = ImageIO.read(new File("adasroom.jpg"));
			image1 = ImageIO.read(new File("image0.jpg"));
			image2 = ImageIO.read(new File("image1.jpg"));
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

}