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
import model.SimplePlayer;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class AddPlayerInnerPanel extends JPanel 
{
	private String id, name;
	private int  points;
	private JTextField textField1, textField2, textField3; 
	private AbstractButton b = new JToggleButton("Submit Player");
	private DiceFrame frame;
	private Player player;
	
	/*
	 * This constructor creates 3 labels as well as 3 textfields
	 * for the user to insert information for a player they wish to add
	 */
	public AddPlayerInnerPanel(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{	
		this.frame = frame;
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
		add(b);
		group.add(b);
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * if a valid player is returned via enterAction method
				 * that player is added into the gameEngine and the UI panel is changed
				 */
				player = enterAction(model, b);
				if(player!=null)
				{
					model.addNewPlayer(player);
					
					/*
					 * Updates status2 on the statusBar
					 */
					statusBar.changeStatus2(model.getAllPlayers().size());
					
					/*
					 * Changing the frames panels once a new player has been added.
					 */
					frame.getSplitFrame().setTopComponent(new DiceDefaultPanel(model, frame, statusBar));
					frame.getSplitFrame().setBottomComponent(new SummaryPanel(model, statusBar));
					frame.updatePanel();
					/*
					 * A dialog box that indicates to the user a new player has been added.
					 */
					JOptionPane.showMessageDialog(frame, "Player successfully added.");

				}
				
			}
		});
	}
	
	/*
	 * Returns a player if the information in the textfields are valid to
	 * create a Player object
	 */
	private Player enterAction(DicePairModel model, AbstractButton b)
	{
		try {
		this.id = textField1.getText();
		this.name = textField2.getText();
		this.points = Integer.parseInt(textField3.getText());
		textField1.setText("");
		textField2.setText("");
		textField3.setText("");
		return new SimplePlayer(id, name, points);
		}catch 
		(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(frame, "Points must be a number");
			System.out.println("Points must be a number");
		}
		return null;
	}
}
