package view;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import model.DicePairModel;

@SuppressWarnings("serial")
public class DiceToolbar extends JToolBar
{	
	public DiceToolbar(DicePairModel model, DiceFrame frame)
	{
		ButtonGroup group = new ButtonGroup();

		AbstractButton b = new JToggleButton("Add Player");
		this.add(b);
		group.add(b);
		AbstractButton q= new JToggleButton("Remove Player");
		this.add(q);
		group.add(q);
		AddPlayerPanel ap = new AddPlayerPanel(model, frame);
		
		RemovePlayerPanel rp = new RemovePlayerPanel(model, frame);
		b.addActionListener((e) -> {
	        frame.setContentPane(ap);
	        frame.invalidate();
	        frame.validate();
	    });
	
		q.addActionListener((e) -> {
	        frame.setContentPane(rp);
	        frame.invalidate();
	        frame.validate();
	    });
	}

}
