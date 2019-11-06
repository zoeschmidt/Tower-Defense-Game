/* Zoe Schmidt
 * CSIS 1410
 * Tower Defense Project - MovingTowerDefenseObject class
 */ 
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MovingTowerDefenseObject extends TowerDefenseObject {

	//Moving objects need velocities
	protected int velX;
	protected int velY;
	
	//MovingTowerDefenseObject constructor
	public MovingTowerDefenseObject(int theX, int theY, int width, int height, BufferedImage theImage, int velX, int velY){
		super(theX, theY, width, height, theImage);
		
		//Sets what it's given as velocities to the variables
		this.velX= velX;
		this.velY= velY;
		
	}

	//Overrides the TowerDefenseObject's drawTheImage method because we want to change the position as well
	//@Override
	public void drawTheImage(Graphics g) {
		
		g.drawImage(theImage, theX, theY, width, height, null);
		theX += velX;
		theY += velY;
		
	}
	
	//Changes velocities
	public void changeV(int x, int y)
	{
		velX = x; velY = y;
	}
	
	
	//Getters and Setters
	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
}
