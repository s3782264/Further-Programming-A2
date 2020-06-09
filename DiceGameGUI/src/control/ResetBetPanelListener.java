package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.DicePairModel;
import view.DiceFrame;
import view.DiceStatus;
import view.ResetBetPanel;

public class ResetBetPanelListener implements ActionListener
{
	private DicePairModel model;
	private DiceFrame frame;
	private DiceStatus statusBar;
	public ResetBetPanelListener(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		this.model = model;
		this.frame = frame;
		this.statusBar = statusBar;
	}
	
	/*
	 * If players exist within the game change the top component panel
	 * to ResetBetPanel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ResetBetPanel rs = new ResetBetPanel(model, frame, statusBar);
		
		if(!model.getAllPlayers().isEmpty())
		{
			frame.getSplitFrame().setTopComponent(rs);
			frame.updatePanel();
			System.out.println("Select the player you wish to reset the bet of.");
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "There are no players in the game");
		}
		
	}

}
