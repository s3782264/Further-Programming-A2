package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import model.DicePairModel;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class DiceStatus extends JPanel
{
	private JLabel status1, status2, status3;
	public DiceStatus(DicePairModel model, DiceFrame frame)
	{
		setLayout(new GridLayout(1, 0));
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		/*
		 * JLabels are created for the status bar
		 */
		status1 = new JLabel("Dice Game");
		status2 = new JLabel("No. of players: " + String.valueOf(model.getAllPlayers().size()), SwingConstants.CENTER);
		if(model.getSelectedPlayer()!=null)
		{
			status3 = new JLabel("Player selected " + model.getSelectedPlayer().getPlayerName(), SwingConstants.RIGHT);
		}
		else{
			status3 = new JLabel("No player currently selected", SwingConstants.RIGHT);
		}
		/*
		 * Border is set for the status'
		 */
		status3.setBorder(border);
		status1.setBorder(border);
		status2.setBorder(border);
		
		add(status1);
		add(status2);
		add(status3);
	}
	
	/*
	 * Updates the status3 label
	 */
	public void changeStatus3(Player player)
	{
		status3.setText("Player selected " + player.getPlayerName());
	}
	
	/*
	 * Updates the status2 label
	 */
	public void changeStatus2(int size)
	{
		status2.setText("No. of players: " + size);
	}
}
