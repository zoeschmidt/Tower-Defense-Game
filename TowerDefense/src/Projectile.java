/* Zoe Schmidt
 * CSIS 1410
 * Tower Defense Project - Projectile class
 */ 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Projectile extends MovingTowerDefenseObject {
	
	//Projectile constructor
	public Projectile(int theX, int theY, int width, int height, BufferedImage theImage, int velX, int velY){
		super(theX, theY, width, height, theImage, velX, velY);
		
		this.theX = theX;
		this.theY = theY;
		this.velX = velX;
		this.velY = velY;
		
	}
	
	//Draws the bullets (Projectiles)
	public void drawTheImage(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(theX, theY, 10,10);
		theX+=velX;
		theY+=velY;
	}
	
	//Move method to move the projectiles
	public void move(int x, int y)
	{
		theX = x;
		theY = y;
	}
	
	
	//Getters and setters
	public int getX() {
		return theX+velX;
	}
	public int getY() {
		return theY+velY;
	}
}
