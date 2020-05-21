package view;

import java.awt.GridBagLayout;
import java.awt.TextField;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import model.DicePairModel;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class RemovePlayerPanel extends JPanel 
{
	private JTextField textField1; 
	private AbstractButton b;

	public RemovePlayerPanel(DicePairModel model, DiceFrame frame)
	{
		setLayout(new GridBagLayout());

		JLabel l = new JLabel("Enter the ID of the Player you wish to remove", JLabel.HORIZONTAL);
		add(l);
		textField1 = new JTextField("",20);
		l.setLabelFor(textField1);
		add(textField1);
		
		ButtonGroup group = new ButtonGroup();
		b = new JToggleButton("Submit Player");
		add(b);
		group.add(b);
		b.addActionListener((e) -> {
	        enterAction(model, b);
	    });
	}
	
	private void enterAction(DicePairModel model, AbstractButton b)
	{
		Player p = model.getPlayer(textField1.getText());
		model.removePlayer(p);
		b.setEnabled(false);
	}
}
