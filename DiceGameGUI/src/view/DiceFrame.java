package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DiceFrame extends JFrame
{
	public DiceFrame()
	{
		super("Dice Game Assignment");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		
		
		setSize(1000, 500);
		
		setVisible(true);
	}
}
