package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.DicePairModel;
import view.DiceFrame;
import view.DiceGamePanel;
import view.DiceStatus;

public class DiceGamePanelListener implements ActionListener
{
	private DicePairModel model;
	private DiceFrame frame;
	private DiceStatus statusBar;
	public DiceGamePanelListener(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		this.model = model;
		this.frame = frame;
		this.statusBar = statusBar;
	}
	
	/*
	 * If players exist in the game the top panel should be changed
	 * to DiceGamePanel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		DiceGamePanel dp = new DiceGamePanel(model, frame, statusBar);

		if(!model.getAllPlayers().isEmpty())
		{ 
			frame.getSplitFrame().setTopComponent(dp);
			frame.updatePanel();
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "There are no players in the game");
		}
	}

}
