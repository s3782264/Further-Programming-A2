package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.DicePairModel;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel 
{
	public SummaryPanel(DicePairModel model, DiceStatus statusBar)
	{
		setLayout(new GridLayout(4,0));
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		add(new JLabel("Summary Panel"));
		
		if(!model.getAllPlayers().isEmpty())
		{
			for(Player player : model.getAllPlayers())
			{
				JLabel summary = new JLabel(player.toString());
				summary.setBorder(border);
				add(summary);
			}
		}
		else
		{
			add(new JLabel("There are currently no players in the game"));
		}

		setVisible(true);
	}
}
