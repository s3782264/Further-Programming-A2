package view;

import java.awt.BorderLayout;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import control.ResetBetListener;
import model.DicePairModel;

@SuppressWarnings("serial")
public class ResetBetPanel extends JPanel
{
	private AbstractButton b;
	private DiceFrame frame;
	public ResetBetPanel(DicePairModel model, DiceFrame frame)
	{
		setLayout(new BorderLayout(20,200));
		this.frame = frame;
		
		add(new PlayerToolbar(model, frame), BorderLayout.NORTH);
		
		JLabel l = new JLabel("Do you wish to reset the bet?");
		add(l, BorderLayout.WEST);
		
		ButtonGroup group = new ButtonGroup();
		b = new JToggleButton("Reset Bet");
		add(b, BorderLayout.CENTER);
		group.add(b);
		
		b.addActionListener(new ResetBetListener(model, frame));
	}
}
