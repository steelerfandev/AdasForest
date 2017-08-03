import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FirstTown extends JPanel{
	
	private BufferedImage imageTown;
	

	public FirstTown(){
		//just have one image and its the town
		JButton townToLibrary = new JButton("To Library");

		townToLibrary.setPreferredSize(new Dimension(120, 40));

		addButton(townToLibrary);
		// do the onclick listener
		townToLibrary.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				Main.removeFirstTownFromPanel();
				Main.addFirstLibrary();
				System.out.println("New objective: Find the librarian!");
				return;
			}
		});

		try { // you have to do this in case it cant find the image

			// put the images into the image array
			imageTown = ImageIO.read(new File("imageTown.jpg"));
		} catch (Exception e) { // catch dat exception
			e.printStackTrace(); // idk what this does rly but just keep it
									// there
		}
	}
	
	public void paintComponent(Graphics g) { // so you can draw the images
		super.paintComponent(g); // just call the superclass

		// paint first image
		g.drawImage(imageTown, 0, 0, null);
	}

	private void addButton(JButton b) {
		super.add(b);
	}
}
