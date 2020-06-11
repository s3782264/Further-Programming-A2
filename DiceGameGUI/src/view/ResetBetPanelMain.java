package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import model.DicePairModel;

@SuppressWarnings("serial")
public class ResetBetPanelMain extends JPanel 
{
	public ResetBetPanelMain(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		setLayout(new BorderLayout());
		
		add(new PlayerToolbar(model, frame, statusBar), BorderLayout.NORTH);
		
		add(new ResetBetInnerPanel(model, frame, statusBar), BorderLayout.CENTER);
		
		add(statusBar, BorderLayout.SOUTH);
	}
}
