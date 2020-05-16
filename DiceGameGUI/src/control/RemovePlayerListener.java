package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DiceModel;
import model.SimplePlayer;
import view.RemovePlayerPanel;

public class RemovePlayerListener implements ActionListener
{
	private DiceModel model;
	
	public RemovePlayerListener(DiceModel model)
	{
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//new RemovePlayerPanel(model);
	}
	
	
}
