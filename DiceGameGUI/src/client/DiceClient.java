package client;


import javax.swing.SwingUtilities;

import model.DicePairModel;
import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.DiceFrame;
import view.GameEngineCallbackGUI;

public class DiceClient {

	public static void main(String[] args) 
	{
		GameEngine gameEngine = new GameEngineImpl();
		DicePairModel model = new DicePairModel(gameEngine);
		model.addNewPlayer(new SimplePlayer("1","Angela", 5000));
		model.addNewPlayer(new SimplePlayer("2","Samantha", 5000));
		 SwingUtilities.invokeLater(new Runnable()
		 {
		 @Override
		 public void run()
		 {
				new DiceFrame(model);
		 }
		 });
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(model));

	}
	
}
