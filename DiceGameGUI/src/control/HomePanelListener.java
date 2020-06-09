package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DicePairModel;
import view.DiceDefaultPanel;
import view.DiceFrame;
import view.DiceStatus;

public class HomePanelListener implements ActionListener
{
	private DiceFrame frame;
	private DicePairModel model;
	private DiceStatus statusBar;
	public HomePanelListener(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		this.frame = frame;
		this.model = model;
		this.statusBar = statusBar;
	}
	
	/*
	 * Changes the top panel to the DefaultPanel
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		frame.getSplitFrame().setTopComponent(new DiceDefaultPanel(model, frame, statusBar));
		frame.updatePanel();
		System.out.println("You've been redirected to the home page.");
	}
	
}
