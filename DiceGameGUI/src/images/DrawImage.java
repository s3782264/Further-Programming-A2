package images;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DrawImage extends JFrame
{
	private int width = 200;
	private int height = 200;
	private BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private Graphics2D g = bufferedImage.createGraphics();
	public static void main(String a[]) throws IOException{
        new DrawImage();
 
    }
	
	public DrawImage() throws IOException
	{
		createImage1();
		createImage2();
	}
	public void getBasicImage()
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, 200, 200); //rec
		
		g.setColor(Color.black);
		g.drawRect(0, 0, 200, 200);
	}
	
	public void createImage1() throws IOException 
	{

		getBasicImage();

		g.setColor(Color.black);
		g.fillOval(70, 70, 60, 60);


		File file = new File("image1.png");
		ImageIO.write(bufferedImage, "png", file);
	}
	
	public void createImage2() throws IOException
	{
		getBasicImage();

		g.setColor(Color.black);
		g.fillOval(25, 25, 60, 60);
		
		g.setColor(Color.black);
		g.fillOval(120, 120, 60, 60);


		File file = new File("image2.png");
		ImageIO.write(bufferedImage, "png", file);
	}
}
