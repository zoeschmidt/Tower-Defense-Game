import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MapWithTowers extends JFrame {

	@SuppressWarnings("unused")
	@Override
	public void paint(Graphics g){
		super.paint(g);
		try{

			//Feel free to use a different image, but I just stuck this here for kicks
			BufferedImage towerImage = ImageIO.read(new File("barker_nathan.jpg"));

			//Use this to test your constructor
			//Tower t1 = new Tower(??);
			//t1.drawTheImage(g);
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public static void main (String [] args){
		MapWithTowers m = new MapWithTowers();
		m.setSize(600, 600);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
	}
}

