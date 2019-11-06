/* Zoe Schmidt
 * CSIS 1410
 * Tower Defense Project - Tower class
 */ 
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Tower extends TowerDefenseObject{
	
	private Projectile p;
	private int velX;
	private int velY; 
	
	//Creates an array list of projectiles for the tower to use
	private ArrayList<Projectile> fires = new ArrayList<Projectile>();
	
	//Integer for creating time inbetween firing
	private int clock;
	
	//Tower constructor
	public Tower(int theX, int theY, int width, int height, BufferedImage theImage, int velX, int velY) {
		super(theX, theY, width, height, theImage);
		
		this.velX = velX;
		this.velY = velY;
		clock = 0;
	}

	//When this is called from Panel class, it lets the towers fire
	public void fireAtEnemy(Graphics g) {
		
			//It waits 3 cycles everytime til it fires again
				if (clock == 0) {
					
					//Makes a projectile and adds it to the array list for the tower
					p = new Projectile(theX, theY, width, height, theImage, velX, velY);
					fires.add(p);
					clock = 4;
				}
				else { //Decrease the clock
					--clock;
				}
				
				//Calls the drawTheImage method to draw each projectile
				for (int i = 0; i < fires.size(); i++) 
					fires.get(i).drawTheImage(g);
	}
	
	//Move method to move the tower to where the user selects
	public void move(int x, int y)
	{
		theX = x;
		theY = y;
	}

	//Getters and Setters
	public Projectile getP() {
		return p;
	}

	public void setP(Projectile p) {
		this.p = p;
	}

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