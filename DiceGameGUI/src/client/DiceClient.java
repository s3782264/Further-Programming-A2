package client;

import javax.swing.SwingUtilities;

import view.GameEngineCallbackGUI;

public class DiceClient {

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new GameEngineCallbackGUI();
			}
		});
	}

}
