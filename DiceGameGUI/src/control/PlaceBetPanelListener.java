package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.DicePairModel;
import view.DiceFrame;
import view.DiceStatus;
import view.PlaceBetPanelMain;

public class PlaceBetPanelListener implements ActionListener
{
	private DicePairModel model;
	private DiceFrame frame;
	private DiceStatus statusBar;
	
	public PlaceBetPanelListener(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		this.model = model;
		this.frame = frame;
		this.statusBar = statusBar;
	}

	/*
	 * If players exist within the game change the top component 
	 * to PlaceBetPanel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!model.getAllPlayers().isEmpty())
		{
			frame.getSplitFrame().setTopComponent(new PlaceBetPanelMain(model, frame, statusBar));
			frame.updatePanel();
			System.out.println("Select a player and place a bet for that player.");
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "There are no players in the game");
		}
	}
}
