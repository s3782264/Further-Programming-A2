package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum DiceFace 
{
	ONE("one", "image1.png"),
    TWO("two", "image2.png"),
    THREE("three", "image3.png"),
    FOUR("four", "image4.png"),
    FIVE("five", "image5.png"),
    SIX("six", "image6.png");

    private String faceValue;
    private ImageIcon icon;
    
	DiceFace(String faceValue, String filename)
	{
		this.faceValue = faceValue;
		this.icon = new ImageIcon(filename, faceValue);
	}
	
	public Icon getIcon()
	{
		return icon;
	}
	
	public int getNumericValue()
	{
		if(faceValue.equals("one"))
		{
			return 1;
		}
		if(faceValue.equals("two"))
		{
			return 2;
		}if(faceValue.equals("three"))
		{
			return 3;
		}if(faceValue.equals("four"))
		{
			return 4;
		}if(faceValue.equals("five"))
		{
			return 5;
		}if(faceValue.equals("six"))
		{
			return 6;
		}
		return 0;
	}
}
