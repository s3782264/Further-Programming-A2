package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import model.DicePairModel;

@SuppressWarnings("serial")
public class AddPlayerPanelMain extends JPanel
{
	/*
	 * This JPanel is the main panel for the AddPlayer feature
	 */
	public AddPlayerPanelMain(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		setLayout(new BorderLayout());
		
		add(new AddPlayerInnerPanel(model, frame, statusBar));
		
		add(statusBar, BorderLayout.SOUTH);
		
		setVisible(true);
	}
}
