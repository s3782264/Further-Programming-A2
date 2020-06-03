package view;

import model.DicePairModel;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class GameEngineCallbackGUI extends GameEngineCallbackImpl
{
	public GameEngineCallbackGUI() 
	{
		
	}
	
	public void playerDieUpdate(Player player, Die die, GameEngine gameEngine, DicePairModel model)
	{
		model.setDiceFace(die);
	}
}
