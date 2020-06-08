package model;

import java.util.Collection;

public class DieModel implements ObservableDice
{
	private DicePairModel model;
	private DiceFace face;
	private Collection<DiceObserver> observers;
	
	public DieModel(DicePairModel model, DiceFace face) 
	{
		this.model = model;
		this.face = face;
	}
	
	public DiceFace getDiceFace()
	{
		return face;
	}
	
	public void setFace(DiceFace face)
	{
		this.face = face;
	}
	
	public void updateDiceFace()
	{
		//setFace(model.getDiceFace());
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
