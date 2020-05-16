package view;

import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class DiceMenu extends JMenuBar implements PropertyChangeListener
{
	private ButtonGroup group;
	
	public DiceMenu()
	{
		super();
		
		//File menu
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_E);
		exit.addActionListener(e -> {System.exit(0);});
		file.add(exit);
		add(file);
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) 
	{
		// TODO Auto-generated method stub
		
	}

}
