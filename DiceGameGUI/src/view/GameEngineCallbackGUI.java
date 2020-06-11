package view;


import javax.swing.SwingUtilities;

import model.DiceFace;
import model.DicePairModel;
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
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				if(die.getNumber()==1)
				{
					switch(die.getValue()) 
					{
					case 1:
						model.getPanel().setLabel1(DiceFace.values()[0].getIcon());
						break;
					case 2:
						model.getPanel().setLabel1(DiceFace.values()[1].getIcon());
						break;
					case 3:
						model.getPanel().setLabel1(DiceFace.values()[2].getIcon());
						break;
					case 4:
						model.getPanel().setLabel1(DiceFace.values()[3].getIcon());
						break;
					case 5:
						model.getPanel().setLabel1(DiceFace.values()[4].getIcon());
						break;
					case 6:
						model.getPanel().setLabel1(DiceFace.values()[5].getIcon());
						break;
					}
				}
				if(die.getNumber()==2)
				{
					switch(die.getValue()) 
					{
					case 1:
						model.getPanel().setLabel2(DiceFace.values()[0].getIcon());
						break;
					case 2:
						model.getPanel().setLabel2(DiceFace.values()[1].getIcon());
						break;
					case 3:
						model.getPanel().setLabel2(DiceFace.values()[2].getIcon());
						break;
					case 4:
						model.getPanel().setLabel2(DiceFace.values()[3].getIcon());
						break;
					case 5:
						model.getPanel().setLabel2(DiceFace.values()[4].getIcon());
						break;
					case 6:
						model.getPanel().setLabel2(DiceFace.values()[5].getIcon());
						break;
					}
				}
			}
		});
	}

	public void playerResult(Player player, DicePair result, GameEngine gameEngine)
	{
		super.playerResult(player, result, gameEngine);
		
	}
	
	public void houseDieUpdate(Die die, GameEngine gameEngine)
	{
		super.houseDieUpdate(die, gameEngine);
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				if(die.getNumber()==1)
				{
					switch(die.getValue()) 
					{
					case 1:
						model.getPanel().setLabel1(DiceFace.values()[0].getIcon());
						break;
					case 2:
						model.getPanel().setLabel1(DiceFace.values()[1].getIcon());
						break;
					case 3:
						model.getPanel().setLabel1(DiceFace.values()[2].getIcon());
						break;
					case 4:
						model.getPanel().setLabel1(DiceFace.values()[3].getIcon());
						break;
					case 5:
						model.getPanel().setLabel1(DiceFace.values()[4].getIcon());
						break;
					case 6:
						model.getPanel().setLabel1(DiceFace.values()[5].getIcon());
						break;
					}
				}
				if(die.getNumber()==2)
				{
					switch(die.getValue()) 
					{
					case 1:
						model.getPanel().setLabel2(DiceFace.values()[0].getIcon());
						break;
					case 2:
						model.getPanel().setLabel2(DiceFace.values()[1].getIcon());
						break;
					case 3:
						model.getPanel().setLabel2(DiceFace.values()[2].getIcon());
						break;
					case 4:
						model.getPanel().setLabel2(DiceFace.values()[3].getIcon());
						break;
					case 5:
						model.getPanel().setLabel2(DiceFace.values()[4].getIcon());
						break;
					case 6:
						model.getPanel().setLabel2(DiceFace.values()[5].getIcon());
						break;
					}
				}
			}
		});
	}
	
	public void houseResult(DicePair result, GameEngine gameEngine) 
	{
		super.houseResult(result, gameEngine);
		
		model.setHouseResult(result);
	}
}
