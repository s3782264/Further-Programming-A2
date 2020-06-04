package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import control.AddPlayerPanelListener;
import control.DiceGamePanelListener;
import control.HomePanelListener;
import control.PlaceBetPanelListener;
import control.ResetBetPanelListener;
import control.RemovePlayerPanelListener;
import model.DicePairModel;
import model.SimplePlayer;

@SuppressWarnings("serial")
public class DiceMenu extends JMenuBar implements PropertyChangeListener
{	
	private JMenuItem addPlayer, removePlayer, home, exit, roll, placeBet, removeBet;
	public DiceMenu(DicePairModel model, DiceFrame frame)
	{
		super();

		//File menu
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		home = new JMenuItem("Home");
		home.setMnemonic(KeyEvent.VK_E);
		home.addActionListener(new HomePanelListener(model, frame));
		file.add(home);
		add(file);

		exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_E);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				{System.exit(0);}
			}
		});
		file.add(exit);
		add(file);

		//Player Menu
		
		model.addNewPlayer(new SimplePlayer("1", "ang", 5000));
		JMenu player = new JMenu("Player Menu");
		player.setMnemonic(KeyEvent.VK_S);
		addPlayer = new JMenuItem("Add Player");
		addPlayer.setMnemonic(KeyEvent.VK_E);
		AddPlayerPanel ap = new AddPlayerPanel(model, frame);
		player.add(addPlayer);
		addPlayer.addActionListener(new AddPlayerPanelListener(model, frame, ap));

		removePlayer = new JMenuItem("Remove Player");
		removePlayer.setMnemonic(KeyEvent.VK_E);
		RemovePlayerPanel rp = new RemovePlayerPanel(model, frame);
		player.add(removePlayer);
		removePlayer.addActionListener(new RemovePlayerPanelListener(model,frame, rp));
		add(player);
		
		placeBet = new JMenuItem("Place Bet");
		placeBet.setMnemonic(KeyEvent.VK_E);
		player.add(placeBet);
		placeBet.addActionListener(new PlaceBetPanelListener(model, frame));
		add(player);
		
		removeBet = new JMenuItem("Remove/Reset Bet");
		removeBet.setMnemonic(KeyEvent.VK_E);
		player.add(removeBet);
		removeBet.addActionListener(new ResetBetPanelListener(model, frame));

		//Dice Game Menu
		JMenu game = new JMenu("Dice game");
		game.setMnemonic(KeyEvent.VK_S);
		roll = new JMenuItem("Roll");
		roll.setMnemonic(KeyEvent.VK_E);
		game.add(roll);
		
		roll.addActionListener(new DiceGamePanelListener(model, frame));
		add(game);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) 
	{
		// TODO Auto-generated method stub

	}

}
