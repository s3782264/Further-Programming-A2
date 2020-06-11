package view;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DiceFace;
import model.DicePairModel;

@SuppressWarnings("serial")
public class DicePanel extends JPanel
{
	JLabel diceOne = new JLabel(DiceFace.values()[0].getIcon());
	JLabel diceTwo = new JLabel(DiceFace.values()[1].getIcon());
	
	public DicePanel(DicePairModel model)
	{
		add(diceOne);
		add(diceTwo);
		
	}

	public void setLabel1(Icon icon)
	{
		diceOne.setIcon(icon);;
	}
	
	public void setLabel2(Icon icon)
	{
		diceTwo.setIcon(icon);
	}
}
