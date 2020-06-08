package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.DicePairModel;

@SuppressWarnings("serial")
public class DiceFrame extends JFrame
{
	private DiceStatus statusBar;
	public DiceFrame(DicePairModel model)
	{
		super("Dice Game Assignment");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		setLayout(new BorderLayout());
		
		statusBar = new DiceStatus(model, this);

		setContentPane(new DiceDefaultPanel(model, this));
		
		setJMenuBar(new DiceMenu(model, this, statusBar));
		
		setSize(1000, 500);
		
		this.add(statusBar, BorderLayout.SOUTH);
		
		setVisible(true);
	}

}
