package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.DicePairModel;
import view.DiceFrame;
import view.DiceGamePanel;

public class DiceGamePanelListener implements ActionListener
{
	private DicePairModel model;
	private DiceFrame frame;
	
	public DiceGamePanelListener(DicePairModel model, DiceFrame frame)
	{
		this.model = model;
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		DiceGamePanel dp = new DiceGamePanel(model, frame);

		if(!model.getAllPlayers().isEmpty())
		{ 
			frame.setContentPane(dp);
			frame.invalidate();
			frame.validate();
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "There are no players in the game");
		}
	}

}
