package view;

import java.awt.GridBagLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import model.DicePairModel;
import model.SimplePlayer;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class AddPlayerPanel extends JPanel
{
	private String id, name;
	private int  points;
	private JTextField textField1, textField2, textField3; 
	private AbstractButton b;
	
	public AddPlayerPanel(DicePairModel model, DiceFrame frame)
	{	

		setLayout(new GridBagLayout());


		JLabel l = new JLabel("Player ID:", JLabel.HORIZONTAL);
		add(l);
		textField1 = new JTextField("",20);
		l.setLabelFor(textField1);
		add(textField1);

		JLabel n = new JLabel("Player Name: ", JLabel.HORIZONTAL);
		add(n);
		textField2 = new JTextField("",20);
		n.setLabelFor(textField2);
		add(textField2);

		JLabel p = new JLabel("Points: ", JLabel.HORIZONTAL);
		add(p);
		textField3 = new JTextField("",20);
		p.setLabelFor(textField3);
		add(textField3);


		ButtonGroup group = new ButtonGroup();
		b = new JToggleButton("Submit Player");
		add(b);
		group.add(b);
		b.addActionListener((e) -> {
			Player player = enterAction(model, b);
			model.addNewPlayer(player);
			frame.setContentPane(new PlaceBetPanel(model, frame, player));
			frame.invalidate();
			frame.validate();
		});

	}
	
	private Player enterAction(DicePairModel model, AbstractButton b)
	{
		this.id = textField1.getText();
		this.name = textField2.getText();
		this.points = Integer.parseInt(textField3.getText());
		return new SimplePlayer(id, name, points);
	}
}
