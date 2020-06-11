package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collection;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.DicePanel;

public class DicePairModel
{
	private GameEngine gameEngine;
	private DieModel dieFace1;
	private DieModel dieFace2;
	private Player rollingPlayer;
	private DicePanel panel;
	public static final String DICE_ONE = "Dice";
	
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	public DicePairModel(GameEngine g)
	{
		this.gameEngine = g;
	}
	
	/*/
	 * Calls rollPlayer from gameEngine
	 */
	public void rollPlayer(Player player)
	{
		gameEngine.rollPlayer(player, 100,1000,100,50,500,50);
		System.out.println(player.getPlayerName() + " is now rolling");
	}
	
	/*
	 * Calls rollHouse from gameEngine
	 */
	public void rollHouse()
	{
		gameEngine.rollHouse(100,1000,100,50,500,50);
		System.out.println("The house is now rolling");
	}
	
	/*/
	 * A player is added into the gameEngine
	 */
	public void addNewPlayer(Player player) 
	{
		gameEngine.addPlayer(player);
		System.out.println("Player added: " + player.toString());
	}
	
	/*
	 * A player is removed from the gameEngine
	 */
	public void removePlayer(Player player)
	{
		gameEngine.removePlayer(player);
		System.out.println("Player removed: " + player.toString());
	}
	
	/*
	 * Places a bet for a specific player
	 */
	public boolean placeBet(Player player, int bet)
	{
		return gameEngine.placeBet(player, bet);
	}
	
	/*
	 * Sets a player who is currently selected 
	 */
	public void setSelectedPlayer(Player player)
	{
		this.rollingPlayer = player;
	}
	
	/*
	 * Returns a player who is marked as selected
	 */
	public Player getSelectedPlayer()
	{
		return rollingPlayer;
	}
	
	//Setters and getters
	public void setDieModel1(DieModel die)
	{
		dieFace1 = die;
		this.pcs.firePropertyChange(DICE_ONE, dieFace1, die);
	}
	
	public void setDieModel2(DieModel die)
	{
		dieFace2 = die;
	}
	
	public DieModel getDie1()
	{
		return dieFace1;
	}

	public DieModel getDie2()
	{
		return dieFace2;
	}
	
	public Collection<Player> getAllPlayers()
	{
		return gameEngine.getAllPlayers();
	}

	public Player getPlayer(String id)
	{
		return gameEngine.getPlayer(id);
	}
	
	public void setPanel(DicePanel panel)
	{
		this.panel = panel;
	}
	
	public DicePanel getPanel()
	{
		return panel;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}
}
