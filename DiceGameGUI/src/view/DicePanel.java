package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DiceFace;
import model.DicePairModel;
import model.DieModel;

@SuppressWarnings("serial")
public class DicePanel extends JPanel  implements PropertyChangeListener
{
	JLabel diceOne = new JLabel(DiceFace.values()[0].getIcon());
	JLabel diceTwo = new JLabel(DiceFace.values()[1].getIcon());
	
	public DicePanel(DicePairModel model)
	{
		if(model.getDie1()!=null)
		{
			diceOne = new DiceFaceView(model.getDie1());
			//diceTwo = new DiceFaceView(model.getDie2());
		}
		add(diceOne);
		add(diceTwo);
		
		model.addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName() == DicePairModel.DICE_ONE)
		{
			add(new DiceFaceView((DieModel) evt.getNewValue()));
			
			validate();
		}
	}
}
