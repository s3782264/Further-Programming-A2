package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import control.AddPlayerPanelListener;
import control.DiceGamePanelListener;
import control.HomePanelListener;
import control.PlaceBetPanelListener;
import control.RemovePlayerPanelListener;
import control.ResetBetPanelListener;
import model.DicePairModel;

@SuppressWarnings("serial")
public class DiceMenu extends JMenuBar
{	
	private JMenuItem addPlayer, removePlayer, home, exit, roll, placeBet, removeBet;
	public DiceMenu(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		super();

		/*
		 * File JMenu
		 */
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		/*
		 * create a home menu option
		 */
		home = new JMenuItem("Home");
		home.setMnemonic(KeyEvent.VK_E);
		/*
		 * Add a listener to the home option
		 */
		home.addActionListener(new HomePanelListener(model, frame, statusBar));
		file.add(home);
		add(file);
		
		/*
		 * Create an exit option
		 */
		exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_E);
		/*
		 * Adds a listener to exit the program
		 */
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				{System.exit(0);}
			}
		});
		file.add(exit);
		add(file);

		/*
		 * Player Menu
		 */

		JMenu player = new JMenu("Player Menu");
		player.setMnemonic(KeyEvent.VK_E);
		/*
		 * Creates a Add Player option
		 */
		addPlayer = new JMenuItem("Add Player");
		addPlayer.setMnemonic(KeyEvent.VK_E);
		AddPlayerPanel ap = new AddPlayerPanel(model, frame, statusBar);
		player.add(addPlayer);
		/*
		 * Adds a listener to the addPlayer option
		 */
		addPlayer.addActionListener(new AddPlayerPanelListener(model, frame, ap));

		/*
		 * Creates a Remove Player option
		 */
		removePlayer = new JMenuItem("Remove Player");
		removePlayer.setMnemonic(KeyEvent.VK_E);
		RemovePlayerPanel rp = new RemovePlayerPanel(model, frame, statusBar);
		player.add(removePlayer);
		/*
		 * Adds a listener to the remove player option
		 */
		removePlayer.addActionListener(new RemovePlayerPanelListener(model,frame, rp));
		add(player);
		
		/*
		 * Creates a place bet option
		 */
		placeBet = new JMenuItem("Place Bet");
		placeBet.setMnemonic(KeyEvent.VK_E);
		player.add(placeBet);
		/*
		 * Adds a listener to the place bet option
		 */
		placeBet.addActionListener(new PlaceBetPanelListener(model, frame, statusBar));
		add(player);
		
		/*
		 * Creates a remove bet option
		 */
		removeBet = new JMenuItem("Remove/Reset Bet");
		removeBet.setMnemonic(KeyEvent.VK_E);
		player.add(removeBet);
		/*
		 * Adds a listener to the option
		 */
		removeBet.addActionListener(new ResetBetPanelListener(model, frame, statusBar));

		/*
		 * Dice Game Menu
		 */
		JMenu game = new JMenu("Dice game");
		game.setMnemonic(KeyEvent.VK_E);
		/*
		 * Creates a roll option
		 */
		roll = new JMenuItem("Roll");
		roll.setMnemonic(KeyEvent.VK_O);
		game.add(roll);
		/*
		 * Adds a listener to the roll option
		 */
		roll.addActionListener(new DiceGamePanelListener(model, frame, statusBar));
		add(game);
	}
}
