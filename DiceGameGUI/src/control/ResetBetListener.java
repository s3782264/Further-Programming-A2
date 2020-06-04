package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.DicePairModel;
import model.interfaces.Player;
import view.DiceDefaultPanel;
import view.DiceFrame;

public class ResetBetListener implements ActionListener
{
	private DicePairModel model;
	private DiceFrame frame;
	
	public ResetBetListener(DicePairModel model, DiceFrame frame)
	{
		this.model = model;
		this.frame = frame;
	}

	@Override	
	public void actionPerformed(ActionEvent e) {
		Player player = model.getSelectedPlayer();
		if(player != null)
		{
			player.resetBet();
			frame.setContentPane(new DiceDefaultPanel(model, frame));
			frame.invalidate();
			frame.validate();
			JOptionPane.showMessageDialog(frame, "Bet successfully reset");
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "Please select a player");

		}
	}
}
