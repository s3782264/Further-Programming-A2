package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.DicePairModel;

@SuppressWarnings("serial")
public class DiceFrame extends JFrame
{
	public DiceFrame(DicePairModel model)
	{
		super("Dice Game Assignment");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		setLayout(new BorderLayout());
		
		setContentPane(new DiceDefaultPanel());
		
		setJMenuBar(new DiceMenu(model, this));
		
		//add(new DiceToolbar(model, this), BorderLayout.NORTH);
		
		
		setSize(1000, 500);
		
		setVisible(true);
	}
}
