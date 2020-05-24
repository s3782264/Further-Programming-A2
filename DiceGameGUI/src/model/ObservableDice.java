package model;

public interface ObservableDice 
{
	void register(DiceObserver observer);
	
	void remove(DiceObserver observer);
	
	void updateAll();
}
