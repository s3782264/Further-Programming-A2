package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import model.DicePairModel;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class DiceStatus extends JPanel implements PropertyChangeListener
{
	private JLabel status1, status2, status3;
	public DiceStatus(DicePairModel model, DiceFrame frame)
	{
setLayout(new GridLayout(1, 0));
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		status1 = new JLabel("Dice Game");
		
		status2 = new JLabel("No. of players: " + String.valueOf(model.getAllPlayers().size()), SwingConstants.CENTER);
		if(model.getSelectedPlayer()!=null)
		{
			status3 = new JLabel("Player selected " + model.getSelectedPlayer().getPlayerName());
		}
		else{
			status3 = new JLabel("No player currently selected", SwingConstants.RIGHT);
		}
		status3.setBorder(border);
		status1.setBorder(border);
		status2.setBorder(border);
		
		add(status1);
		add(status2);
		add(status3);
	}
	
	public void changeStatus3(Player player)
	{
		status3 = new JLabel("Player selected " + player.getPlayerName());
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}
}