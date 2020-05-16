package view;

import model.DiceModel;
import model.GameEngineImpl;

public class GameEngineCallbackGUI 
{
	public GameEngineCallbackGUI()
	{
		new DiceFrame(new DiceModel(new GameEngineImpl()));
	}
}
