package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.DiceModel;
import model.SimplePlayer;
import view.AddPlayerPanel;

public class AddPlayerListener implements ActionListener
{
	private DiceModel model;
	
	public AddPlayerListener(DiceModel model) throws IllegalArgumentException 
	{		
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		//new AddPlayerPanel(model);
	}	
}
