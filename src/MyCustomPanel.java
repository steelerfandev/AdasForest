
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.*;

public class MyCustomPanel extends JPanel implements MouseMotionListener {

	private int mouseX;
	private int mouseY;
	private String userName;
	private BufferedImage image;
	public boolean buttonClicked;
	
	public MyCustomPanel() {
		JLabel title = new JLabel("Ada's Forest");
		JButton start = new JButton("Start Your Adventure");
		
		super.add(title);
		
		start.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "IT WORKS");
				start.setVisible(false);
				title.setText("");
			}
			
		});
		super.add(start); // this adds the button to the panel
		super.addMouseMotionListener(this); // adds the mouse motion listener to
											// the panel
	}
	
	private void changeBackground() {
		super.setBackground(
				new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		super.repaint();
	}
	
	/*public MyCustomPanel() {
		super();

		JButton randomButton = new JButton("random");
		randomButton.addActionListener(new ActionListener() {
			@Override // following method is in the original superclass and you
						// are overriding it
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Null colored pen");
				changeBackground();
			}
		});
		super.add(randomButton); // this adds the button to the panel
		super.addMouseMotionListener(this); // adds the mouse motion listener to
											// the panel

		// button to ask user for name
		JButton nameGetter = new JButton("User Name");
		nameGetter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userName = JOptionPane.showInputDialog("Enter your name.");
			}
		});
		super.add(nameGetter); // this adds the button to the panel

		try {
			image = ImageIO.read(new File("image.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void changeBackground() {
		super.setBackground(
				new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
	}

	@Override
	public void paintComponent(Graphics g) { // check the graphics ide
		super.paintComponent(g);
		g.setColor(new Color(mouseX % 256, mouseY % 256, (mouseX * mouseY) % 256)); // 8
																					// bit
																					// color
		g.fillOval(mouseX - 35, mouseY - 35, 70, 70);

		if (userName != null && (int) (Math.random() * 5) == 0) {
			g.setFont(new Font("ARIAL", Font.BOLD, 200)); // set font to arial
															// 20 pixels
			g.drawString(userName, (int) (Math.random() * g.getClipBounds().getWidth()),
					(int) (Math.random() * g.getClipBounds().getHeight())); // randomly
																			// draws
																			// name
																			// on
																			// screen
		}
		g.drawImage(image, 0, 0, null);
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		super.repaint();
	}*/

}
