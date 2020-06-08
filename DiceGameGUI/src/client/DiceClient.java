package client;


import javax.swing.SwingUtilities;

import model.DicePairModel;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.DiceFrame;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;

public class DiceClient {

	public static void main(String[] args) 
	{
		GameEngine gameEngine = new GameEngineImpl();
		DicePairModel model = new DicePairModel(gameEngine);
		 SwingUtilities.invokeLater(new Runnable()
		 {
		 @Override
		 public void run()
		 {
				new DiceFrame(model);
		 }
		 });


		//gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(model));
		
	}
	
}
