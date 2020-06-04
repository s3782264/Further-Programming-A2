package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.DicePairModel;
import view.DiceFrame;
import view.ResetBetPanel;

public class ResetBetPanelListener implements ActionListener
{
	private DicePairModel model;
	private DiceFrame frame;
	
	public ResetBetPanelListener(DicePairModel model, DiceFrame frame)
	{
		this.model = model;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ResetBetPanel rs = new ResetBetPanel(model, frame);
		
		if(!model.getAllPlayers().isEmpty())
		{
			frame.setContentPane(rs);
			frame.invalidate();
			frame.validate();
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "There are no players in the game");
		}
		
	}

}
