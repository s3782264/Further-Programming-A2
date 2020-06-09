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
	public ResetBetPanel(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		setLayout(new BorderLayout(20,120));
		
		add(new PlayerToolbar(model, frame, statusBar), BorderLayout.NORTH);
		
		add(statusBar, BorderLayout.SOUTH);
		
		JLabel l = new JLabel("Do you wish to reset the bet?");
		add(l, BorderLayout.WEST);
		
		ButtonGroup group = new ButtonGroup();
		b = new JToggleButton("Reset Bet");
		add(b, BorderLayout.CENTER);
		
		JLabel S = new JLabel("                      "
				+ "                          "
				+ "                      ");
		add(S, BorderLayout.EAST);
		group.add(b);
		
		b.addActionListener(new ResetBetListener(model, frame, statusBar));
	}
}
