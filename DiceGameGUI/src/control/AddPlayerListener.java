package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DicePairModel;
import model.interfaces.Player;

public class AddPlayerListener implements ActionListener
{
	private DicePairModel model;
	private Player player;
	
	public AddPlayerListener(DicePairModel model, Player player) throws IllegalArgumentException 
	{		
		this.model = model;
		this.player = player;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		model.addNewPlayer(player);
	}	
}
