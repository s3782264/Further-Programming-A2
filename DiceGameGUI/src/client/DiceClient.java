package client;

import javax.swing.SwingUtilities;

import model.DicePairModel;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.DiceFrame;
import view.GameEngineCallbackGUI;

public class DiceClient {

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				GameEngine gameEngine = new GameEngineImpl();
				gameEngine.addGameEngineCallback(new GameEngineCallbackGUI());
				new DiceFrame(new DicePairModel(gameEngine));
			}
		});
	}

}
