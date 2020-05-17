package view;

import model.DicePairModel;
import model.GameEngineImpl;

public class GameEngineCallbackGUI 
{
	public GameEngineCallbackGUI()
	{
		new DiceFrame(new DicePairModel(new GameEngineImpl()));
	}
}
