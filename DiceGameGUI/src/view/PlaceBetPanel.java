package view;

import java.awt.Frame;
import java.awt.GridBagLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import model.DicePairModel;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class PlaceBetPanel extends JPanel 
{
	private JTextField textField1; 
	private AbstractButton b;

	public PlaceBetPanel(DicePairModel model, DiceFrame frame, Player player)
	{
		setLayout(new GridBagLayout());
		
		JLabel l = new JLabel("Enter the bet", JLabel.HORIZONTAL);
		add(l);
		textField1 = new JTextField("",20);
		l.setLabelFor(textField1);
		add(textField1);
		
		ButtonGroup group = new ButtonGroup();
		b = new JToggleButton("Submit Player");
		add(b);
		group.add(b);
		b.addActionListener((e) -> {
	        enterAction(model, b, player);
	    });
	}
	
	private void enterAction(DicePairModel model, AbstractButton b, Player player)
	{
		int bet = Integer.parseInt(textField1.getText());
		model.placeBet(player, bet);
		System.out.println(player.toString());
	}
}
