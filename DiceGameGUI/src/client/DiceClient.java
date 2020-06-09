package client;


import model.DicePairModel;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.DiceFrame;
import view.GameEngineCallbackGUI;

public class DiceClient {

	public static void main(String[] args) 
	{
		GameEngine gameEngine = new GameEngineImpl();
		DicePairModel model = new DicePairModel(gameEngine);

		new DiceFrame(model);

		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(model));

	}
	
}
