package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DicePairModel;
import model.SimplePlayer;
import view.RemovePlayerPanel;

public class RemovePlayerListener implements ActionListener
{
	private DicePairModel model;
	
	public RemovePlayerListener(DicePairModel model)
	{
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//new RemovePlayerPanel(model);
	}
	
	
}
