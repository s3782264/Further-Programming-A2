package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DicePairModel;
import view.AddPlayerPanelMain;
import view.DiceFrame;
import view.DiceStatus;

public class AddPlayerPanelListener implements ActionListener
{
	private DiceFrame frame;
	private DicePairModel model;
	private DiceStatus statusBar;
	public AddPlayerPanelListener(DicePairModel model, DiceFrame frame, DiceStatus statusBar) {
		this.frame = frame;
		this.model = model;
		this.statusBar = statusBar;
	}
	
	/*
	 * Changes the top panel of the frame to AddPlayerPanel
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		frame.getSplitFrame().setTopComponent(new AddPlayerPanelMain(model, frame, statusBar));
		frame.updatePanel();
		System.out.println("Enter the details of the player you wish to add.");
	}
}
