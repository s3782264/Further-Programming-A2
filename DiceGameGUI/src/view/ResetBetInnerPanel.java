package view;

import java.awt.GridBagLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import control.ResetBetListener;
import model.DicePairModel;

@SuppressWarnings("serial")
public class ResetBetInnerPanel extends JPanel
{
	private AbstractButton b;
	public ResetBetInnerPanel(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		setLayout(new GridBagLayout());
				
		JLabel l = new JLabel("Do you wish to reset the bet of the currently selected player? ");
		add(l);
		
		/*
		 * Create a reset bet button
		 */
		ButtonGroup group = new ButtonGroup();
		b = new JToggleButton("Reset Bet");
		add(b);
		group.add(b);
		/*
		 * A listener is added to th button
		 */
		b.addActionListener(new ResetBetListener(model, frame, statusBar));
	}
}
