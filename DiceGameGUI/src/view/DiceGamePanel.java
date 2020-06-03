package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import model.DiceFace;
import model.DicePairModel;

@SuppressWarnings("serial")
public class DiceGamePanel extends JPanel
{
	private DiceFrame frame;
	private AbstractButton b;
	ButtonGroup group = new ButtonGroup();
	JLabel diceOne = new JLabel(DiceFace.values()[0].getIcon());
	JLabel diceTwo = new JLabel(DiceFace.values()[1].getIcon());
	public DiceGamePanel(DicePairModel model, DiceFrame frame)
	{
		setLayout(new BorderLayout(20,20));
		this.frame = frame;
		add(new PlayerToolbar(model, frame), BorderLayout.NORTH);
		b = new JToggleButton("Roll");
		b.setMaximumSize(new Dimension(60,60));
		add(b, BorderLayout.WEST);
		
		group.add(b);
		add(diceOne, BorderLayout.CENTER);
		add(diceTwo, BorderLayout.EAST);
		
		b.addActionListener((e) -> {
			model.rollPlayer(model.getSelectedPlayer());
			diceOne = new JLabel(model.getDiceFace().getIcon());
		});
	}
}
