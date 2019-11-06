/* Zoe Schmidt
 * CSIS 1410
 * Tower Defense Project - JPanel
 */ 

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.scene.shape.Rectangle;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.util.Arrays;


@SuppressWarnings("serial") //prevents the serial warning

public class Panel extends JPanel {
	
	private int l; //Variable for keeping track of lives
	private int xx; //Variable for helping the towers aim based on the x
	private int yy; //Variable for helping the towers aim based on the y
	
	//ArrayLists to store the towers and Enemies and Projectiles created
	private ArrayList<Tower> drawMe;
	private ArrayList<Enemy> drawMe2;
	private ArrayList<Projectile> drawMe3;
	
	//Variable to store the coordinates where the user clicked
	private int xClick;
	private int	yClick;
	
	public Panel() 
	{
		xClick = 0;
		yClick = 0;
		
		//MouseListener detects where the mouse was clicked
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Gets the coordinates of the click and stores them
				xClick = e.getX();
				yClick = e.getY();
				
				//Depending on if the click was above the enemies and to the right or so on
				//it sends xx and yy to the methods velocity and yVelocity in GameDriver to help aim
				if(yClick < 300 && xClick > 150) { //1
					xx = -10;
					yy = 10;
					GameDriver.velocity(xx);
					GameDriver.yVelocity(yy);
				}
				if(yClick < 300 && xClick < 150) { //2
					xx = 10;
					yy = 10; //**
					GameDriver.velocity(xx);
					GameDriver.yVelocity(yy);
				}
				if(yClick > 300 && xClick > 150) { //3
					xx = -10;
					yy = -10;
					GameDriver.velocity(xx);
					GameDriver.yVelocity(yy);
				}
				if(yClick > 300 && xClick < 150) { //4
					xx = 10;
					yy = -10;
					GameDriver.velocity(xx);
					GameDriver.yVelocity(yy);
				}
				
			}
		}); 
		
		//Sets the lives to three in the no argument constructor
		l = 3;
	}

	//Adds a Tower object to the arraylist drawMe
	public void addObject(Tower so)
	{
		//moves the set position of the tower to where the user clicked
		so.move(xClick, yClick);
		drawMe.add(so); 
		
	}
	
	//Adds an Enemy to the arraylist drawMe2
	public void addObject(Enemy mo)
	{
		drawMe2.add(mo); 
	}
	
	//Adds a Projectile to the arraylist drawMe3
	public void addProjectile(Projectile p) 
	{
		//Moves the set position of the projectile to where the user clicked (the tower)
		p.move(xClick, yClick);
		drawMe3.add(p);
	}
	
	//Method that checks if the projectile is touching an enemy
	public boolean checkCollision() {
		
		//Goes through the Enemy arraylist and the projectile arraylist
		for(Enemy mo : drawMe2) { 
			
			for(Projectile p : drawMe3) {
			
				//if they're touching return false and print "hit"
			if(mo != null && p != null && (p.getX() > mo.getX() && (p.getX() < mo.getX()+39)) && (p.getY() > mo.getY() && (p.getY() < mo.getY()+59))) {
		
				System.out.println("hit");
				return false;
				}
			}
	
		}
		
		return true;	
	}
	
	//Paint method that loops 
	@SuppressWarnings("unused")
	@Override
	public void paint(Graphics g){
		super.paint(g); //Calls the super parent paint
		
		try{
			//For every tower in the tower arraylist, draw it and fire it
			for(Tower so : drawMe)
			{
				if (so != null)
				{
					so.drawTheImage(g);
	
						((Tower) so).fireAtEnemy(g);
			}
			
			//For every projectile in the arraylist, draw it if it's not out of bounds
			for(Projectile p : drawMe3)
			{
				
				if (p != null && p.getX() < 400 && p.getY() < 600)
				{
					p.drawTheImage(g);
				}
			}
			
			
			//For every enemy in the Enemy arraylist
			for(Enemy mo : drawMe2)
			{
				//Check if theres a collision and if there is print that it has occured and which enemy then set the enemy to null
				if(checkCollision() == false) {
					System.out.println("Check collision is true and enemy is removed");
					System.out.println(mo);
					drawMe2.set(drawMe2.indexOf(mo), null);
				}
				
				//if the enemy is not null and it is within bounds and theres no collision, draw the enemy
				if (mo != null && mo.getX() < 350 && checkCollision())
				{
					mo.drawTheImage(g);
				}
			
				
				//if enemy is not null and it's out of bounds, set the enemy to null and deduct from lives
			if(mo != null) {
				if(mo.getX() >= 350){		
							drawMe2.set(drawMe2.indexOf(mo), null);
							l--;
							 GameDriver.lives(l); //Send the method lives in GameDriver the current number of lives
							
							if(l <= 0) { //If there's no more lives, print that you lose and stop the game
								System.out.println("You lose");
								
								//Intentionally creates an exception to stop the game
								int a = 5;
								int b = 0;
								int c;
								c = a/b;
								break;
						}		
					}
				}
			
			}
			
				Thread.sleep(1000);//got to slow things down to see
				repaint();//refresh the screen so things aren't drawn on top of each other
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

