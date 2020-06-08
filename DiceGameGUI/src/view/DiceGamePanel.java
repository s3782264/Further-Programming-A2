package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

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
		add(new PlayerToolbar(model, frame, statusBar), BorderLayout.NORTH);
		add(statusBar, BorderLayout.SOUTH);
		b = new JToggleButton("Roll");
		b.setMaximumSize(new Dimension(60,60));
		add(b, BorderLayout.WEST);
		
		group.add(b);
	
		DicePanel panel = new DicePanel(model);
		add(panel);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.getSelectedPlayer()!=null)
				{
					if(model.getSelectedPlayer().getBet()!=0)
					{
					new Thread()
					{
						@Override
						public void run()
						{
							
							b.setEnabled(false);
							model.rollPlayer(model.getSelectedPlayer());
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
					else
					{
						JOptionPane.showMessageDialog(frame, "Your player doesn't have a bet");
						frame.setContentPane(new PlaceBetPanel(model, frame, statusBar));
						frame.invalidate();
						frame.validate();
					}
				}
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


