package model;

public class DicePairModel 
{
	private GameEngineImpl gameEngine;
	public DicePairModel(GameEngineImpl g)
	{
		this.gameEngine = g;
	}
	
	public void addNewPlayer(SimplePlayer player)
	{
		gameEngine.addPlayer(player);
		System.out.println("Player added: " + player.toString());
	}
	
	public void removePlayer(SimplePlayer player)
	{
		gameEngine.removePlayer(player);
		System.out.println("Player removed: " + player.toString());
	}
}
