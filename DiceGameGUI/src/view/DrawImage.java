package view;

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
		createImage3();
		createImage4();
		createImage5();
		createImage6();
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

		g.fillOval(20, 20, 60, 60);
		
		g.fillOval(120, 120, 60, 60);


		File file = new File("image2.png");
		ImageIO.write(bufferedImage, "png", file);
	}
	
	public void createImage3() throws IOException
	{
		getBasicImage();
		
		g.fillOval(20, 20, 60, 60);
		
		g.fillOval(120, 120, 60, 60);
		
		g.fillOval(70, 70, 60, 60);
		
		File file = new File("image3.png");
		ImageIO.write(bufferedImage, "png", file);
	}
	
	public void createImage4() throws IOException
	{
		getBasicImage();
		
		g.fillOval(15, 15, 60, 60);
		
		g.fillOval(15, 125, 60, 60);
		
		g.fillOval(125, 15, 60, 60);
		
		g.fillOval(125, 125, 60, 60);

		File file = new File("image4.png");
		ImageIO.write(bufferedImage, "png", file);
	}
	
	public void createImage5() throws IOException
	{
		getBasicImage();

		g.fillOval(70, 70, 60, 60);
		
		g.fillOval(15, 15, 60, 60);

		g.fillOval(15, 15, 60, 60);

		g.fillOval(15, 125, 60, 60);

		g.fillOval(125, 15, 60, 60);

		g.fillOval(125, 125, 60, 60);

		File file = new File("image5.png");
		ImageIO.write(bufferedImage, "png", file);
	}
	
	public void createImage6() throws IOException
	{
		getBasicImage();
		
		g.fillOval(15, 7, 60, 60);
		
		g.fillOval(15, 133, 60, 60);
			
		g.fillOval(125, 7, 60, 60);
		
		g.fillOval(125, 133, 60, 60);
		
		g.fillOval(15, 70, 60, 60);
		
		g.fillOval(125, 70, 60, 60);
		
		
		File file = new File("image6.png");
		ImageIO.write(bufferedImage, "png", file);
	}
}
