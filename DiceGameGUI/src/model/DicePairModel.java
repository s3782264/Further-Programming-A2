package model;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class DicePairModel implements Iterable<DieModel>
{
	private GameEngine gameEngine;
	private DiceFace face;
	private Collection<DieModel> dieFaces;
	private Player rollingPlayer;
	public static final String NEW_PLAYER_ADDED = "New player added";
	
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	public DicePairModel(GameEngine g)
	{
		this.gameEngine = g;
	}
	
	public void rollPlayer(Player player)
	{
		gameEngine.rollPlayer(player, 100,1000,100,50,500,50);
	}
	
	public void addNewPlayer(Player player) 
	{
		gameEngine.addPlayer(player);
		System.out.println("Player added: " + player.toString());
		this.pcs.firePropertyChange(NEW_PLAYER_ADDED, null, player);
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
		
		System.out.println("You selected player " + player.getPlayerName());
	}
	
	public Player getSelectedPlayer()
	{
		return rollingPlayer;
	}
	
	public DiceFace getDiceFace()
	{
		return face;
	}
	
	public void setDiceFace(Die die)
	{
		if(die.getValue() ==1)
		{
			face = DiceFace.values()[0];
		}
		else if(die.getValue() ==2)
		{
			face = DiceFace.values()[1];
		}
		else if(die.getValue() ==3)
		{
			face = DiceFace.values()[2];
		}
		else if(die.getValue() ==4)
		{
			face = DiceFace.values()[3];
		}
		else if(die.getValue() ==5)
		{
			face = DiceFace.values()[4];
		}
		else if(die.getValue() ==6)
		{
			face = DiceFace.values()[5];
		}
	}
	
	//public void 

	@Override
	public Iterator<DieModel> iterator() 
	{
		return dieFaces.iterator();
	}

	
}
