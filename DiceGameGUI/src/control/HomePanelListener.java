package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DiceDefaultPanel;
import view.DiceFrame;

public class HomePanelListener implements ActionListener
{
	private DiceFrame frame;
	public HomePanelListener(DiceFrame frame)
	{
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		frame.setContentPane(new DiceDefaultPanel());
		frame.invalidate();
		frame.validate();
	}
	
}
