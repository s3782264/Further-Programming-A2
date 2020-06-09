package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collection;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class DicePairModel
{
	private GameEngine gameEngine;
	private DieModel dieFace1;
	private DieModel dieFace2;
	private Player rollingPlayer;
	public static final String DICE_ONE = "Dice";
	
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	public DicePairModel(GameEngine g)
	{
		this.gameEngine = g;
	}
	
	public void rollPlayer(Player player)
	{
		gameEngine.rollPlayer(player, 100,1000,100,50,500,50);
	}
	
	public void rollHouse()
	{
		gameEngine.rollHouse(100,1000,100,50,500,50);
	}
	
	public void addNewPlayer(Player player) 
	{
		gameEngine.addPlayer(player);
		System.out.println("Player added: " + player.toString());
	}
	
	public void removePlayer(Player player)
	{
		gameEngine.removePlayer(player);
		System.out.println("Player removed: " + player.toString());
	}
	
	public Collection<Player> getAllPlayers()
	{
		return gameEngine.getAllPlayers();
	}
	
	public Player getPlayer(String id)
	{
		return gameEngine.getPlayer(id);
	}
	
	public boolean placeBet(Player player, int bet)
	{
		return gameEngine.placeBet(player, bet);
	}
	
	
	public void setSelectedPlayer(Player player)
	{
		this.rollingPlayer = player;
	}
	
	public Player getSelectedPlayer()
	{
		return rollingPlayer;
	}
	
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

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}
}
