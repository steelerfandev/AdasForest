import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FirstLibrary extends JPanel implements MouseListener {

	private int mouseX, mouseY;
	// new objective ask librarian about trees

	// slide 0 - librarian says how can i help you, button says where can i find
	// books about trees
	// slide 1- librarian says right over there, button says thank you
	// slide 2 - see bookshelf, "click on the green book to open it." - click
	// the door style button
	// slide 3 - first slide of book! (fact about trees can get sick from
	// polluted water)
	// slide 4 - second slide of book (fact about epa)
	// slide 5 - third slide of book (fact about grocery store revenue)
	// slide 6 - fourth slide of book (fact about recycling paper)
	// slide 7 - fifth slide of book (fact about reusable water bottles)
	// slide 8 - librarian "how can i help you?" (button option "why do trees
	// get sick from polluted water")
	// slide 9 - librarian says "go ask mrs teacher" - consult google doc,
	// button says "thanks bye"
	// slide 10 - librarian is seen throwing out checkout receipt - button "WTF
	// ARE YOU DOIN"
	// slide 11 - she says "i was just going to throw out your receipt" - button
	// says "did you know..."
	// slide 12 - "wow, that's interesting. Thanks ada" - button says "go to
	// school"

	private BufferedImage image0;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;
	private BufferedImage image7;
	private BufferedImage image8;
	private BufferedImage image9;
	private BufferedImage image10;
	private BufferedImage image11;
	private BufferedImage image12;
	private BufferedImage image13;
	private BufferedImage[] imageArray;
	private int numImage = 0;

	public FirstLibrary() {
		// define the buttons

		// slide 0 - librarian says how can i help you, button says where can i
		// find books about trees
		// slide 1- librarian says right over there, button says thank you
		// slide 2 - see bookshelf, "click on the green book to open it." -
		// click the door style button
		// slide 3 - first slide of book! (fact about trees can get sick from
		// polluted water)
		// slide 4 - second slide of book (fact about epa)
		// slide 5 - third slide of book (fact about grocery store revenue)
		// slide 6 - fourth slide of book (fact about recycling paper)
		// slide 7 - fifth slide of book (fact about reusable water bottles)
		// slide 8 - librarian "how can i help you?" (button option "why do
		// trees get sick from polluted water")
		// slide 9 - librarian says "go ask mrs teacher" - consult google doc,
		// button says "thanks bye"
		// slide 10 - librarian is seen throwing out checkout receipt - button
		// "WTF ARE YOU DOIN"
		// slide 11 - she says "i was just going to throw out your receipt" -
		// button says "did you know..."
		// slide 12 - "wow, that's interesting. Thanks ada" - button says "go to
		// school"
		JButton whereTrees = new JButton("Where can I find books about trees?");
		JButton thankYou = new JButton("Thank you!");
		JButton nextPage = new JButton("Next Page");
		JButton exit = new JButton("Exit Book");
		JButton whySick = new JButton("Why do trees get sick from polluted water?");
		JButton thanksBye = new JButton("Thanks, bye!");
		JButton whatTheHeck = new JButton("What are you doing?");
		JButton didYouKnow = new JButton("Did you know that every ton of recycled paper saves 17 trees?");
		JButton goToSchool = new JButton("Go to School");
		
		thankYou.setVisible(false);
		nextPage.setVisible(false);
		exit.setVisible(false);
		whySick.setVisible(false);
		thanksBye.setVisible(false);
		whatTheHeck.setVisible(false);
		didYouKnow.setVisible(false);
		goToSchool.setVisible(false);

		whereTrees.setPreferredSize(new Dimension(500, 40));
		addButton(whereTrees); // this adds the button to the panel

		// do the onclick listener
		whereTrees.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage++;
				whereTrees.setVisible(false);
				thankYou.setVisible(true);
				repaint();

				if (numImage == 1) {
					addButton(thankYou); // this adds the button to the panel
				}
			}
		});

		thankYou.setPreferredSize(new Dimension(120, 40));
		addButton(thankYou); // this adds the button to the panel

		// do the onclick listener
		thankYou.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage++;
				thankYou.setVisible(false);
				nextPage.setVisible(true);
				repaint();

				if (numImage == 2) {
					addButton(nextPage); // this adds the button to the panel
				}
			}
		});
		nextPage.setPreferredSize(new Dimension(200, 40));
		addButton(nextPage); // this adds the button to the panel

		// do the onclick listener
		nextPage.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage++;
				repaint();
				if (numImage == 3) {
					System.out.println("Trees can get sick from polluted water.");
				}
				if (numImage == 4) {
					System.out
							.println("The Environmental Protection Agency is an organization devoted to saving trees.");
				}
				if (numImage == 5) {
					System.out.println(
							"For every $1000 a grocery store makes in revenue, 10 lbs of food waste is created.");
				}
				if (numImage == 6) {
					System.out.println("Every ton of paper recycled saves 17 trees.");
				}
				if (numImage == 7) {
					System.out.println("Reusable water bottles consume 2000x less energy to fill than bottled water.");
				}
				if (numImage == 8) {
					nextPage.setVisible(false);
					exit.setVisible(true);
				}
			}
		});
		exit.setPreferredSize(new Dimension(90, 40));
		addButton(exit); // this adds the button to the panel

		// do the onclick listener
		exit.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage++;
				exit.setVisible(false);
				whySick.setVisible(true);
				repaint();

				if (numImage == 9) {
					addButton(whySick); // this adds the button to the panel
				}
			}
		});
		whySick.setPreferredSize(new Dimension(500, 40));
		addButton(whySick); // this adds the button to the panel

		// do the onclick listener
		whySick.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage++;
				whySick.setVisible(false);
				thanksBye.setVisible(true);
				repaint();

				if (numImage == 10) {
					addButton(thanksBye); // this adds the button to the panel
				}
			}
		});
		thanksBye.setPreferredSize(new Dimension(200, 40));
		addButton(thanksBye); // this adds the button to the panel

		// do the onclick listener
		thanksBye.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage++;
				thanksBye.setVisible(false);
				whatTheHeck.setVisible(true);
				repaint();

				if (numImage == 11) {
					addButton(whatTheHeck); // this adds the button to the panel
				}
			}
		});
		whatTheHeck.setPreferredSize(new Dimension(400, 40));
		addButton(whatTheHeck); // this adds the button to the panel

		// do the onclick listener
		whatTheHeck.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage++;
				whatTheHeck.setVisible(false);
				didYouKnow.setVisible(true);
				repaint();

				if (numImage == 12) {
					addButton(didYouKnow); // this adds the button to the panel
				}
			}
		});
		didYouKnow.setPreferredSize(new Dimension(600, 40));
		addButton(didYouKnow); // this adds the button to the panel

		// do the onclick listener
		didYouKnow.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				numImage++;
				didYouKnow.setVisible(false);
				goToSchool.setVisible(true);
				repaint();

				if (numImage == 13) {
					addButton(goToSchool); // this adds the button to the panel
				}
			}
		});
		goToSchool.setPreferredSize(new Dimension(200, 40));
		addButton(goToSchool); // this adds the button to the panel

		// do the onclick listener
		goToSchool.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) { // on click
				//remove the panel
				//add the school
			}
		});

		try { // you have to do this in case it cant find the image

			// put the images into the image array
			// CHANGE THE SOURCE OF THESE IMAGES WHEN GRAPHICS ARE CREATED
			image0 = ImageIO.read(new File("image0.jpg"));
			image1 = ImageIO.read(new File("image0.jpg"));
			image2 = ImageIO.read(new File("image0.jpg"));
			image3 = ImageIO.read(new File("image0.jpg"));
			image4 = ImageIO.read(new File("image0.jpg"));
			image5 = ImageIO.read(new File("image0.jpg"));
			image6 = ImageIO.read(new File("image0.jpg"));
			image7 = ImageIO.read(new File("image0.jpg"));
			image8 = ImageIO.read(new File("image0.jpg"));
			image9 = ImageIO.read(new File("image0.jpg"));
			image10 = ImageIO.read(new File("image0.jpg"));
			image11 = ImageIO.read(new File("image0.jpg"));
			image12 = ImageIO.read(new File("image0.jpg"));
			image13 = ImageIO.read(new File("image0.jpg"));

			// instantiate the image array so it is not null
			imageArray = new BufferedImage[14];

			// set up everything in the image array
			imageArray[0] = image0;
			imageArray[1] = image1;
			imageArray[2] = image2;
			imageArray[3] = image0;
			imageArray[4] = image1;
			imageArray[5] = image2;
			imageArray[6] = image0;
			imageArray[7] = image1;
			imageArray[8] = image2;
			imageArray[9] = image0;
			imageArray[10] = image1;
			imageArray[11] = image2;
			imageArray[12] = image0;
			imageArray[13] = image1;

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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY = e.getY();

		// THESE COORDINATES SHOULD BE CHANGED TO CLICK ON BOOK
		if (mouseX > 245 && mouseX < 245 + 191 && mouseY > 216 && mouseY < 600) {
			// Main.removeFirstLibraryFromPanel();
			// Main.addFirstSchool();
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

	private void addButton(JButton b) {
		super.add(b);
	}

}
