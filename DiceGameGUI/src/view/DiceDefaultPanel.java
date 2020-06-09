package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DicePairModel;

@SuppressWarnings("serial")
public class DiceDefaultPanel extends JPanel 
{
	public DiceDefaultPanel(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		setLayout(new BorderLayout());
		
		add(new JLabel("Welcome to Dice Game!"), BorderLayout.CENTER);
		add(statusBar, BorderLayout.SOUTH);
	}
}
