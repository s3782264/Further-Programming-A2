package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.DicePairModel;
import model.SimplePlayer;
import view.AddPlayerPanel;

public class AddPlayerListener implements ActionListener
{
	private DicePairModel model;
	
	public AddPlayerListener(DicePairModel model) throws IllegalArgumentException 
	{		
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		//new AddPlayerPanel(model);
	}	
}
