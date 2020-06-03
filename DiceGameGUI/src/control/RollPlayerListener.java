package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DicePairModel;
import model.interfaces.Player;

public class RollPlayerListener implements ActionListener
{
	private DicePairModel model;
	private Player player;
	public RollPlayerListener(DicePairModel model, Player player) 
	{
		this.model = model;
		this.player = player;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		model.rollPlayer(player);
	}
	
}
