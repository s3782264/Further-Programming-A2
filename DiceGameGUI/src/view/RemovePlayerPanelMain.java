package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import model.DicePairModel;

@SuppressWarnings("serial")
public class RemovePlayerPanelMain extends JPanel 
{
	/*
	 * This is the main panel for removing a player
	 */
	public RemovePlayerPanelMain(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		setLayout(new BorderLayout());
		
		add(new RemovePlayerInnerPanel(model, frame, statusBar));
		
		add(statusBar, BorderLayout.SOUTH);
	}
}
