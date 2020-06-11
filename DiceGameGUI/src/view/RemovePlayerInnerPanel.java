package view;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import model.DicePairModel;

@SuppressWarnings("serial")
public class RemovePlayerInnerPanel extends JPanel 
{
	private AbstractButton b;
	private DiceFrame frame;
	public RemovePlayerInnerPanel(DicePairModel model, DiceFrame frame, DiceStatus statusBar)
	{
		setLayout(new GridBagLayout());
		this.frame = frame;
		JLabel l = new JLabel("Select the player you wish to remove. ", JLabel.HORIZONTAL);
		add(l);
	
		ButtonGroup group = new ButtonGroup();
		b = new JToggleButton("Remove Player");
		add(b);
		group.add(b);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				enterAction(model);
				
				statusBar.changeStatus2(model.getAllPlayers().size());
				statusBar.changeStatus3(null);
				/*
				 * Changes to the frames top panel and bottom panel
				 */
				frame.getSplitFrame().setTopComponent(new DiceDefaultPanel(model, frame, statusBar));
				frame.getSplitFrame().setBottomComponent(new SummaryPanel(model, statusBar));
				frame.updatePanel();
				JOptionPane.showMessageDialog(frame, "Player sucessfully removed");


			}
		});
	}

	/*
	 * Removes a player that has been selected 
	 */
	private void enterAction(DicePairModel model)
	{
		try {
		model.removePlayer(model.getSelectedPlayer());
		}catch (NullPointerException e)
		{
			JOptionPane.showMessageDialog(frame, "Unable to remove Player");
		}
	}
}
