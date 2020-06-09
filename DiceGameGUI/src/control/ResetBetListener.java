package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.DicePairModel;
import model.interfaces.Player;
import view.DiceDefaultPanel;
import view.DiceFrame;
import view.DiceStatus;
import view.SummaryPanel;

public class ResetBetListener implements ActionListener
{
	private DicePairModel model;
	private DiceFrame frame;
	private DiceStatus statusBar;
	
	public ResetBetListener(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		this.model = model;
		this.frame = frame;
		this.statusBar = statusBar;
	}

	/*
	 * if a player has been selected change the top component panel
	 * to DefaultPanel and create a new instance of the bottom component SummaryPanel
	 */
	@Override	
	public void actionPerformed(ActionEvent e) {
		Player player = model.getSelectedPlayer();
		if(player != null)
		{
			player.resetBet();
			frame.getSplitFrame().setTopComponent(new DiceDefaultPanel(model, frame, statusBar));
			frame.getSplitFrame().setBottomComponent(new SummaryPanel(model, statusBar));
			frame.updatePanel();
			JOptionPane.showMessageDialog(frame, "Bet successfully reset");
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "Please select a player");

		}
	}
}
