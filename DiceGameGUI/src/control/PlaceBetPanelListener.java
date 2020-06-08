package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.DicePairModel;
import view.DiceFrame;
import view.DiceStatus;
import view.PlaceBetPanel;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		PlaceBetPanel pp = new PlaceBetPanel(model, frame, statusBar);

		if(!model.getAllPlayers().isEmpty())
		{
			frame.setContentPane(pp);
			frame.invalidate();
			frame.validate();
			System.out.println("Select a player and place a bet for that player.");
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "There are no players in the game");
		}
	}
}
