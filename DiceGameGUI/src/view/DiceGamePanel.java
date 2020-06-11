package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import model.DiceFace;
import model.DicePairModel;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class DiceGamePanel extends JPanel
{
	private AbstractButton b;
	ButtonGroup group = new ButtonGroup();
	JLabel diceOne = new JLabel(DiceFace.values()[0].getIcon());
	JLabel diceTwo = new JLabel(DiceFace.values()[1].getIcon());
	
	public DiceGamePanel(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		setLayout(new BorderLayout(20,20));
		/*
		 * Adds a toolBar to the panel
		 */
		add(new PlayerToolbar(model, frame, statusBar), BorderLayout.NORTH);
		/*
		 * Add a statusBar to the panel
		 */
		add(statusBar, BorderLayout.SOUTH);
		b = new JToggleButton("Roll");
		add(b, BorderLayout.WEST);
		
		group.add(b);
		
		/*
		 * Add the panel with the two diceImages
		 */
		DicePanel panel = new DicePanel(model);
		add(panel);
		model.setPanel(panel);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.getSelectedPlayer()!=null)
				{
					int checkBet =0;
					for(Player player : model.getAllPlayers())
					{
						if(player.getBet()!=0)
						{
							checkBet++;
						}
					}
					if(checkBet == model.getAllPlayers().size())
					{
					new Thread()
					{
						@Override
						public void run()
						{
							/*
							 * Disable the roll button until the selected player had finished rolling
							 */
							b.setEnabled(false);
							model.rollPlayer(model.getSelectedPlayer());
							/*
							 * Creates a new SummaryPanel with the new values
							 */
							frame.getSplitFrame().setBottomComponent(new SummaryPanel(model, statusBar));	
							/*
							 * if all players have rolled automatically roll the house
							 */
							if(model.getAllPlayers()!=null)
							{
								int check =0;
								for(Player player : model.getAllPlayers())
								{
									if(player.getResult()!=null)
									{
										check++;
									}
								}
								if(check == model.getAllPlayers().size())
								{
									model.rollHouse();
								}
							}
							b.setEnabled(true);
							
						}

					}.start();
					}
					/*
					 * Dialog that informs the user the selected player does not have a bet
					 */
					else
					{
						JOptionPane.showMessageDialog(frame, "All Players must have a bet");
						frame.getSplitFrame().setTopComponent(new PlaceBetPanelMain(model, frame, statusBar));
						frame.updatePanel();
						System.out.println("Select a player and place a bet for that player.");
					}
				}
				/*
				 * Dialog that informs the user that no player has been selected
				 */
				else 
				{
					JOptionPane.showMessageDialog(frame, "No player was selected");
				}

			}
		}
				);
	}
	
	public void setDie1(String value) {
		diceOne.setIcon(DiceFace.ONE.getIcon());
	}
}


