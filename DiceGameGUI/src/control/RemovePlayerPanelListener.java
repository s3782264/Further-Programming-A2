package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.DicePairModel;
import view.DiceFrame;
import view.DiceStatus;
import view.RemovePlayerPanelMain;

public class RemovePlayerPanelListener implements ActionListener
{
	private DiceFrame frame;
	private DicePairModel model;
	private DiceStatus statusBar;
	public RemovePlayerPanelListener(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		this.frame = frame;
		this.model = model;
		this.statusBar = statusBar;
	}
	
	/*
	 * If players exist change the top component of the frame to
	 * RemovePlayerPanel
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		if(!model.getAllPlayers().isEmpty())
		{
			frame.getSplitFrame().setTopComponent(new RemovePlayerPanelMain(model, frame, statusBar));
			frame.updatePanel();
			System.out.println("Enter the ID of the player you wish to remove");
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "There are no players in the game to remove");
		}
	}
}
