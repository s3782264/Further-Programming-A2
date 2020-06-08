package view;


import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import model.DiceFace;
import model.DicePairModel;
import model.DieModel;
import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class GameEngineCallbackGUI extends GameEngineCallbackImpl
{
	private DicePairModel model;
	public GameEngineCallbackGUI(DicePairModel model) 
	{
		this.model = model;
	}

	public void playerDieUpdate(Player player, Die die, GameEngine gameEngine)
	{
		super.playerDieUpdate(player, die, gameEngine);
		
		switch(die.getValue()) 
		{
		case 1:
			model.setDieModel1(new DieModel(model, DiceFace.ONE));
			break;
		case 2:
			model.setDieModel1(new DieModel(model, DiceFace.TWO));
			break;
		case 3:
			model.setDieModel1(new DieModel(model, DiceFace.THREE));
			break;
		case 4:
			model.setDieModel1(new DieModel(model, DiceFace.FOUR));
			break;
		case 5:
			model.setDieModel1(new DieModel(model, DiceFace.FIVE));
			break;
		case 6:
			model.setDieModel1(new DieModel(model, DiceFace.SIX));
			break;
		}
	}
	
	public void playerResult(Player player, DicePair result, GameEngine gameEngine)
	{
		super.playerResult(player, result, gameEngine);
		
		
	}
}
