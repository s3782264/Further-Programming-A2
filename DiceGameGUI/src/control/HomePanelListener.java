package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DicePairModel;
import view.DiceDefaultPanel;
import view.DiceFrame;

public class HomePanelListener implements ActionListener
{
	private DiceFrame frame;
	private DicePairModel model;
	public HomePanelListener(DicePairModel model, DiceFrame frame)
	{
		this.frame = frame;
		this.model = model;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		frame.setContentPane(new DiceDefaultPanel(model, frame));
		frame.invalidate();
		frame.validate();
		System.out.println("You've been redirected to the home page.");
	}
	
}
