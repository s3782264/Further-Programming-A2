package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DicePairModel;
import view.AddPlayerPanel;
import view.DiceFrame;

public class AddPlayerPanelListener implements ActionListener
{
	private DiceFrame frame;
	private AddPlayerPanel ap;
	
	public AddPlayerPanelListener(DicePairModel model, DiceFrame frame, AddPlayerPanel ap) {
		this.frame = frame;
		this.ap = ap;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		frame.setContentPane(ap);
		frame.invalidate();
		frame.validate();
	}
}
