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
		
		setContentPane(new DiceDefaultPanel(model, this));
		
		setJMenuBar(new DiceMenu(model, this));
		
		setSize(1000, 500);
		this.add(new DiceStatus(model, this), BorderLayout.SOUTH);
		
		setVisible(true);
	}
}
