package view;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import model.DicePairModel;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class PlaceBetInnerPanel extends JPanel 
{
	private JTextField textField1; 
	private AbstractButton b;
	private DiceFrame frame;
	
	public PlaceBetInnerPanel(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		setLayout(new GridBagLayout());
		this.frame = frame;
			
		JLabel l = new JLabel("Enter the bet");
		add(l);
		textField1 = new JTextField("",20);
		l.setLabelFor(textField1);
		add(textField1);
		
		ButtonGroup group = new ButtonGroup();
		b = new JToggleButton("Submit Bet");
		add(b);
		group.add(b);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Player player = model.getSelectedPlayer();
				if(player !=null)
				{
					/*
					 * 
					 */
					submitAction(model, player);
					if(player.getBet()>0 )
					{
						if(player.getBet() < player.getPoints())
						{
							frame.getSplitFrame().setBottomComponent(new SummaryPanel(model, statusBar));
							frame.updatePanel();
							JOptionPane.showMessageDialog(frame, "Bet successfully added");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Bet must be less than player points");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Please select a player");
				}
			}
		});
	}
	
	/*
	 * Method that places a bet for the player passed in
	 * if no exception was thrown it returns true
	 */
	private boolean submitAction(DicePairModel model, Player player)
	{
		try {
		int bet = Integer.parseInt(textField1.getText());
		model.placeBet(player, bet);
		System.out.println(player.toString());
		textField1.setText("");
		}catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(frame, "Bet must be a number");
			System.out.println("Bet must be a number");
			return false;
		}
		return true;
	}
}
