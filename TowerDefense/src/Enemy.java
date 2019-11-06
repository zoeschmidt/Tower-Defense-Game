/* Zoe Schmidt
 * CSIS 1410
 * Tower Defense Project - Enemy class
 */ 

import java.awt.image.BufferedImage;

public class Enemy extends MovingTowerDefenseObject {
	
	//Enemy constructor
	public Enemy(int theX, int theY, int width, int height, BufferedImage theImage, int velX, int velY, int health){
		super(theX, theY, width, height, theImage, velX, velY);
		
	}
	
}
