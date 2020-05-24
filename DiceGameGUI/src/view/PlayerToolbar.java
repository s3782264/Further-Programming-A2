package view;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import model.DicePairModel;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class PlayerToolbar extends JToolBar
{
	private ButtonGroup group;
	
	public PlayerToolbar(DicePairModel model, DiceFrame frame)
	{
		group = new ButtonGroup();
		
		for(Player player : model.getAllPlayers())
		{
			AbstractButton b = new JToggleButton(player.getPlayerName());
			add(b);
			group.add(b);
			
		}
		setVisible(true);
	}
}