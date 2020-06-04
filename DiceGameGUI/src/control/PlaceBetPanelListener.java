package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.DicePairModel;
import view.DiceFrame;
import view.PlaceBetPanel;

public class PlaceBetPanelListener implements ActionListener
{
	private DicePairModel model;
	private DiceFrame frame;
	
	public PlaceBetPanelListener(DicePairModel model, DiceFrame frame)
	{
		this.model = model;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PlaceBetPanel pp = new PlaceBetPanel(model, frame);

		if(!model.getAllPlayers().isEmpty())
		{
			frame.setContentPane(pp);
			frame.invalidate();
			frame.validate();
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "There are no players in the game");
		}
	}
}
