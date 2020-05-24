package view;

import java.awt.GridBagLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private DiceFrame frame;
	
	public PlaceBetPanel(DicePairModel model, DiceFrame frame, Player player)
	{
		setLayout(new GridBagLayout());
		this.frame = frame;
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
	        if(player.getBet()>0)
	        {
	        	frame.setContentPane(new DiceDefaultPanel());
	        	frame.invalidate();
	        	frame.validate();
	        	JOptionPane.showMessageDialog(frame, "Player successfully added");
	        }
	    });
	}
	
	private void enterAction(DicePairModel model, AbstractButton b, Player player)
	{
		try {
		int bet = Integer.parseInt(textField1.getText());
		model.placeBet(player, bet);
		System.out.println(player.toString());
		textField1.setText("");
		}catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(frame, "Bet must be a number");
			System.out.println("Bet must be a number");
		}
	}
}
