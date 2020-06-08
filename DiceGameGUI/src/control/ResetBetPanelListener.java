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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ResetBetPanel rs = new ResetBetPanel(model, frame, statusBar);
		
		if(!model.getAllPlayers().isEmpty())
		{
			frame.setContentPane(rs);
			frame.invalidate();
			frame.validate();
			System.out.println("Select the player you wish to reset the bet of.");
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "There are no players in the game");
		}
		
	}

}
