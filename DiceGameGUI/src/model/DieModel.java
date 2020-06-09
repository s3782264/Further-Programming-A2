package model;

import java.util.Collection;

public class DieModel implements ObservableDice
{
	private DiceFace face;
	private Collection<DiceObserver> observers;
	
	public DieModel(DicePairModel model, DiceFace face) 
	{
		this.face = face;
	}
	
	public DiceFace getDiceFace()
	{
		return face;
	}
	
	@Override
	public void register(DiceObserver observer) 
	{
		observers.add(observer);
	}

	@Override
	public void remove(DiceObserver observer) 
	{
		observers.remove(observer);
	}

	@Override
	public void updateAll() 
	{
		for(DiceObserver d : observers)
		{
			d.updateFace(face);
		}
	}
}
