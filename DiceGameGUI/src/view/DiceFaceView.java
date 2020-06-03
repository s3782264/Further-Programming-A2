package view;

import javax.swing.JLabel;

import model.DiceFace;
import model.DiceObserver;
import model.DieModel;

@SuppressWarnings("serial")
public class DiceFaceView extends JLabel implements DiceObserver
{
	public DiceFaceView(DieModel die)
	{
		super(die.getDiceFace().getIcon());
		die.register(this);
	}

	@Override
	public void updateFace(DiceFace face) 
	{
		setIcon(face.getIcon());
	}
}
