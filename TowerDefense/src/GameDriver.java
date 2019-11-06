/* Zoe Schmidt
 * CSIS 1410
 * Tower Defense Project - GameDriver class
 */ 
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class GameDriver extends JFrame {
	
	int money = 60; //Money variable
	static int x1; //Integer to help aim depending on the xClick
	static int y1; //Integer to help aim depending on the yClick
	
	//Creates a JLabel outside of the constructor so it can be used by the lives method
	static JLabel lblLives = new JLabel("Current Lives: " + 3);
	
	
	public GameDriver() {
		
			//Creates JPanel for the light gray section
			JPanel panel1 = new JPanel();
			panel1.setBackground(Color.lightGray);
			this.getContentPane().add(BorderLayout.WEST, panel1);
			GridBagLayout gbl_panel1 = new GridBagLayout();
			gbl_panel1.columnWidths = new int[]{117, 101, 0};
			gbl_panel1.rowHeights = new int[]{29, 0, 0, 0, 0, 0, 0};
			gbl_panel1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_panel1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0};
			panel1.setLayout(gbl_panel1);
				
			//Creates panel for the section where the game is gonna be played
			Panel panel2 = new Panel();
			panel2.setBackground(Color.black);
			this.getContentPane().add(BorderLayout.CENTER, panel2);
			
			//Creates JLabel for the money so it can be used when placing the towers
			JLabel label2 = new JLabel();
				
			//Jbutton that starts the game by starting the enemies
				JButton button1 = new JButton("Start");
				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Starting . . .");
						
						try { //Try to create Enemies, using a picture file, and calls a method from the Panel class to add them
							BufferedImage goblin1 = ImageIO.read(new File("Enemy.png"));
							BufferedImage goblin2 = ImageIO.read(new File("Enemy2.png"));
							Enemy mo = new Enemy(0,250, 40, 60, goblin1, 20, 0, 100);
							Enemy mo2 = new Enemy(-100,270, 40, 60, goblin2, 20, 0,100);
							Enemy mo3 = new Enemy(-150,270,40, 60, goblin1, 20, 0, 100);
							Enemy mo4 = new Enemy(-250,290, 40, 60, goblin1, 20, 0,100);
							Enemy mo5 = new Enemy(-300,270, 40, 60, goblin2, 20, 0,100);
							panel2.addObject(mo);
							panel2.addObject(mo2);
							panel2.addObject(mo3);
							panel2.addObject(mo4); 
							panel2.addObject(mo5);
							
							}
							catch (IOException e2) {
								e2.printStackTrace();
							}	
						
						
					}
				});
					GridBagConstraints gbc_button1 = new GridBagConstraints();
					gbc_button1.insets = new Insets(0, 0, 5, 5);
					gbc_button1.anchor = GridBagConstraints.NORTHWEST;
					gbc_button1.gridx = 0;
					gbc_button1.gridy = 0;
					panel1.add(button1, gbc_button1);
					
				
			//Creates an ImageIcon for the Tower.png image
			ImageIcon GIcon = new ImageIcon("Tower.png");
			Image image = GIcon.getImage();
			Image newImage = image.getScaledInstance(80, 110,  java.awt.Image.SCALE_SMOOTH);
			GIcon = new ImageIcon(newImage);
			
			//JButton for adding a tower
			JButton btnNewButton = new JButton(GIcon);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//System.out.println("Tower added to field");
					
					//When adding the tower the money is reduced and the label is updated
					if(money >= 20) {
						money = money - 20;
						label2.setText("Current Amount: $" + money);
					try {
						//Creates Towers and Projectiles and calls a method from the Panel class to add them
					BufferedImage tower = ImageIO.read(new File("Tower.png"));
					BufferedImage projectile = ImageIO.read(new File("Projectile.png"));
					Tower s1 = new Tower(50,50, 40, 60, tower, x1, y1);
					Projectile p = new Projectile(50, 50, 10, 10, projectile, x1, y1);
					panel2.addObject(s1);
					panel2.addProjectile(p);
					
					}
					catch (IOException e2) {
						e2.printStackTrace();
					}
					
					}
					
				}
			});
			
			//Adding image of tower2 and making it a button that when pressed adds it to the panel
			ImageIcon GIcon2 = new ImageIcon("Tower2.png");
			Image image2 = GIcon2.getImage();
			Image newImage2 = image2.getScaledInstance(80, 110, java.awt.Image.SCALE_SMOOTH);
			GIcon2 = new ImageIcon(newImage2);
	
			JButton btnNewButton2 = new JButton(GIcon2);
			btnNewButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//System.out.println("Tower2 added to field");
					
					//When adding the tower the money is reduced and the label is updated
					if(money >= 20) {
						money = money - 20;
						label2.setText("Current Amount: $" + money);
					try {
						//Creates Tower2s and Projectiles and calls a method from the Panel class to add them
						BufferedImage tower2 = ImageIO.read(new File("Tower2.png"));
						BufferedImage projectile = ImageIO.read(new File("Projectile.png"));
						Projectile p2 = new Projectile(50, 50, 10, 10, projectile, x1, y1);
						Tower s2 = new Tower(50, 50, 40, 60, tower2, x1, y1);
						panel2.addObject(s2);
						panel2.addProjectile(p2);
					
					}
					catch (IOException e2){
						e2.printStackTrace();
					}
				
					}
				}
			});
			
			//Layout stuff for the tower2 button
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.insets = new Insets(0, 0, 5, 5);
			gbc_button.gridx = 0;
			gbc_button.gridy = 3;
			panel1.add(btnNewButton2, gbc_button);
			
			//Layout stuff for the tower button
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 0;
			gbc_btnNewButton.gridy = 2;
			panel1.add(btnNewButton, gbc_btnNewButton);
			
			//Layout stuff for the lives JLabel
			GridBagConstraints gbc_lblLives = new GridBagConstraints();
			gbc_lblLives.insets = new Insets(0, 0, 5, 5);
			gbc_lblLives.gridx = 0;
			gbc_lblLives.gridy = 4;
			panel1.add(lblLives, gbc_lblLives);
			
			//Layout stuff for the money JLabel
			label2.setText("Current Amount: $" + money);
			GridBagConstraints gbc_label2 = new GridBagConstraints();
			gbc_label2.insets = new Insets(0, 0, 5, 5);
			gbc_label2.gridx = 0;
			gbc_label2.gridy = 6;
			panel1.add(label2, gbc_label2);
			
			//JLabel and layout stuff for the label that tells you the price
			JLabel label = new JLabel("Each tower costs $20");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 7;
			panel1.add(label, gbc_label);
			gbc_label.gridx = 0;
			gbc_label.gridy = 5;
	
			//Creates an ImageIcon for the RoadTile.png image
			ImageIcon GIcon3 = new ImageIcon("RoadTile.png");
			Image image3 = GIcon3.getImage();
			Image newImage3 = image3.getScaledInstance(500, 100, java.awt.Image.SCALE_SMOOTH);
			GIcon3 = new ImageIcon(newImage3);
			
			//Creates an ImageIcon for the WaterTile.png image
			ImageIcon GIcon4 = new ImageIcon("WaterTile.png");
			Image image4 = GIcon4.getImage();
			Image newImage4 = image4.getScaledInstance(500, 240, java.awt.Image.SCALE_SMOOTH);
			GIcon4 = new ImageIcon(newImage4);
	}
		
	
	//lives method that gets the amount of lives from the Panel class
	public static void lives(int lives) {
		
		//Updates the lives label to the current amount of lives
		lblLives.setText("Current Lives: " + lives);

	}
	
	//velocity method that determines the tower's aim based on the xx from the xClick
	public static void velocity(int xx) {
		x1 = xx;
		//System.out.println("x is " + xx);
	}
	
	//yVelocity method that determines the tower's aim based on the yy from the yClick
	public static void yVelocity(int yy) {
		y1 = yy;
	}
	
	//The Main that sets the JFrame for the game
	public static void main(String[] args) {
		
		GameDriver m = new GameDriver();	
		m.setSize(600, 600);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		
		
	}

}

