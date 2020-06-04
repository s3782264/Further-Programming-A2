package view;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private DiceFrame frame;
	public RemovePlayerPanel(DicePairModel model, DiceFrame frame)
	{
		setLayout(new GridBagLayout());
		this.frame = frame;
		JLabel l = new JLabel("Enter the ID of the Player you wish to remove", JLabel.HORIZONTAL);
		add(l);
		textField1 = new JTextField("",20);
		textField1.setText("");
		l.setLabelFor(textField1);
		add(textField1);
		
		ButtonGroup group = new ButtonGroup();
		b = new JToggleButton("Submit Player");
		add(b);
		group.add(b);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 enterAction(model);
			        if(model.getPlayer(textField1.getText()) == null)
			        {
			        	frame.setContentPane(new DiceDefaultPanel());
			        	frame.invalidate();
			        	frame.validate();
			        	JOptionPane.showMessageDialog(frame, "Player sucessfully removed");
			        }
				
			}
	    });
	}
	
	private void enterAction(DicePairModel model)
	{
		try {
		Player p = model.getPlayer(textField1.getText());
		model.removePlayer(p);
		}catch (NullPointerException e)
		{
			JOptionPane.showMessageDialog(frame, "Unable to remove Player");
		}
	}
}
