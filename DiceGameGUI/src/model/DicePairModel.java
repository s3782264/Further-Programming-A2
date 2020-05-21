package model;

import java.util.Collection;

import model.interfaces.Player;

public class DicePairModel 
{
	private GameEngineImpl gameEngine;
	public DicePairModel(GameEngineImpl g)
	{
		this.gameEngine = g;
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
}
