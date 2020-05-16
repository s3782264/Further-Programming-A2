package view;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.DiceModel;

@SuppressWarnings("serial")
public class RemovePlayerPanel extends JPanel 
{
	private JTextField textField1; 

	public RemovePlayerPanel(DiceModel model, DiceFrame frame)
	{
		setLayout(new GridBagLayout());

		JLabel l = new JLabel("Enter the ID of the Player you wish to remove", JLabel.HORIZONTAL);
		add(l);
		textField1 = new JTextField("",20);
		l.setLabelFor(textField1);
		add(textField1);
	}
}
