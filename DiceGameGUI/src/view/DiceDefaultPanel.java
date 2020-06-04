package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.DicePairModel;

@SuppressWarnings("serial")
public class DiceDefaultPanel extends JPanel 
{
	public DiceDefaultPanel(DicePairModel model, DiceFrame frame)
	{
		setLayout(new BorderLayout());
		
		add(new JLabel("Welcome to Dice Game!"), BorderLayout.CENTER);
		add(new DiceStatus(model, frame), BorderLayout.SOUTH);
	}
}
