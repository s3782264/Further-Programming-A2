package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.DicePairModel;
import view.DiceFrame;
import view.RemovePlayerPanel;

public class RemovePlayerPanelListener implements ActionListener
{
	private DiceFrame frame;
	private RemovePlayerPanel rp;
	private DicePairModel model;
	public RemovePlayerPanelListener(DicePairModel model, DiceFrame frame, RemovePlayerPanel rp)
	{
		this.frame = frame;
		this.rp = rp;
		this.model = model;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		if(!model.getAllPlayers().isEmpty())
		{
			frame.setContentPane(rp);
			frame.invalidate();
			frame.validate();
			System.out.println("Enter the ID of the player you wish to remove");
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "There are no players in the game to remove");
		}
	}
}
