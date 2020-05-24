package view;

import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.DicePairModel;

@SuppressWarnings("serial")
public class DiceMenu extends JMenuBar implements PropertyChangeListener
{	
	private JMenuItem addPlayer, removePlayer, home, exit, roll;
	public DiceMenu(DicePairModel model, DiceFrame frame)
	{
		super();
		
		//File menu
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		home = new JMenuItem("Home");
		home.setMnemonic(KeyEvent.VK_E);
		home.addActionListener(e -> {
			frame.setContentPane(new DiceDefaultPanel());
			frame.invalidate();
	        frame.validate();
			});
		file.add(home);
		add(file);
		
		exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_E);
		exit.addActionListener(e -> {System.exit(0);});
		file.add(exit);
		add(file);
		
		//Player Menu
		JMenu player = new JMenu("Player Menu");
		player.setMnemonic(KeyEvent.VK_S);
		addPlayer = new JMenuItem("Add Player");
		addPlayer.setMnemonic(KeyEvent.VK_E);
		AddPlayerPanel ap = new AddPlayerPanel(model, frame);
		player.add(addPlayer);
		addPlayer.addActionListener((e) -> {
	        frame.setContentPane(ap);
	        frame.invalidate();
	        frame.validate();
	    });
		
		player.setMnemonic(KeyEvent.VK_S);
		removePlayer = new JMenuItem("Remove Player");
		removePlayer.setMnemonic(KeyEvent.VK_E);
		RemovePlayerPanel rp = new RemovePlayerPanel(model, frame);
		player.add(removePlayer);
		removePlayer.addActionListener((e) -> {
	        frame.setContentPane(rp);
	        frame.invalidate();
	        frame.validate();
		});
		add(player);
		
		JMenu game = new JMenu("Dice game");
		game.setMnemonic(KeyEvent.VK_S);
		roll = new JMenuItem("Roll");
		roll.setMnemonic(KeyEvent.VK_E);
		DiceGamePanel dp = new DiceGamePanel(model, frame);
		game.add(roll);
		roll.addActionListener((e) -> {
	        frame.setContentPane(dp);
	        frame.invalidate();
	        frame.validate();
	        });
		add(game);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) 
	{
		// TODO Auto-generated method stub
		
	}

}
