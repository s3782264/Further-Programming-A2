package view;

import java.awt.GridBagLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.plaf.ToolBarUI;

import control.AddPlayerListener;
import model.DiceModel;
import model.SimplePlayer;

@SuppressWarnings("serial")
public class AddPlayerPanel extends JPanel
{
	private String id, name;
	private int  points;
	private JTextField textField1, textField2, textField3; 
	private AbstractButton b;
	
	public AddPlayerPanel(DiceModel model, DiceFrame frame)
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
	        enterAction(model, b);
	    });
	}
	
	private void enterAction(DiceModel model, AbstractButton b)
	{
		this.id = textField1.getText();
		this.name = textField2.getText();
		this.points = Integer.parseInt(textField3.getText());
		model.addNewPlayer(new SimplePlayer(id, name, points));
		b.setEnabled(false);
	}
}
