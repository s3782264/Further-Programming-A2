package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.DiceModel;

@SuppressWarnings("serial")
public class DiceFrame extends JFrame
{
	public DiceFrame(DiceModel model)
	{
		super("Dice Game Assignment");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		setLayout(new BorderLayout());
		
		setJMenuBar(new DiceMenu());
		
		add(new DiceToolbar(model, this), BorderLayout.NORTH);
		
		
		setSize(1000, 500);
		
		setVisible(true);
	}
}
