/* Zoe Schmidt
 * CSIS 1410
 * Tower Defense Project - TowerDefenseObject class
 */ 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TowerDefenseObject {
		
		//Variables that all TowerDefenseObject's will have
		 protected int theX;
		 protected int theY;
		 protected BufferedImage theImage;
		 protected int width;
		 protected int height;
		
		//TowerDefenseObject constructor
		public TowerDefenseObject(int theX, int theY, int width, int height, BufferedImage theImage){
			
			//Sets what it's given to the variables
			this.theX = theX;
			this.theY = theY; 
			this.theImage= theImage;
			this.width = width; 
			this.height = height;
			
		}
		
		//Draws the image based on the variables
		public void drawTheImage(Graphics g) {
			if(g != null) {
			g.drawImage(theImage, theX, theY, width, height, null);
			}
		
		}
		
		
		//Getters and Setters
		public int getX() {
			return theX;
		}
		
		public void setX(int x) {
			this.theX = x;
		}

		public int getY() {
			return theY;
		}

		public void setY(int y) {
			this.theY = y;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public BufferedImage getTheImage() {
			return theImage;
		}

		public void setTheImage(BufferedImage theImage) {
			this.theImage = theImage;
		}
	

}
