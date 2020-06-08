package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public PlayerToolbar(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		group = new ButtonGroup();
		for(Player player : model.getAllPlayers())
		{
			AbstractButton b = new JToggleButton(player.getPlayerName());
			add(b);
			group.add(b);

			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					model.setSelectedPlayer(player);
					statusBar.changeStatus3(player);
					System.out.println("You have selected player: " + model.getSelectedPlayer().getPlayerName());
				}
			});
		}
	}
}
