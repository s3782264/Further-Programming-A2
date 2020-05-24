package view;

import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import model.DicePairModel;

@SuppressWarnings("serial")
public class DiceGamePanel extends JPanel
{
	private DiceFrame frame;
	private AbstractButton b;
	ButtonGroup group = new ButtonGroup();
	public DiceGamePanel(DicePairModel model, DiceFrame frame)
	{
		setLayout(new GridLayout(1, 3));
		this.frame = frame;
		

		b = new JToggleButton("Roll");
		add(b);
		group.add(b);
		
		//JLabel label = dice
	}
}
