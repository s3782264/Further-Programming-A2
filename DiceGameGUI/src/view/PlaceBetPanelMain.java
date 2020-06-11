package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import model.DicePairModel;

@SuppressWarnings("serial")
public class PlaceBetPanelMain extends JPanel 
{
	public PlaceBetPanelMain(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		setLayout(new BorderLayout());
		
		add(new PlayerToolbar(model, frame, statusBar), BorderLayout.NORTH);
		
		add(new PlaceBetInnerPanel(model, frame, statusBar), BorderLayout.CENTER);
		
		add(statusBar, BorderLayout.SOUTH);
	}
}
