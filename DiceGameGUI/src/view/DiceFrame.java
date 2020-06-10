package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import model.DicePairModel;

@SuppressWarnings("serial")
public class DiceFrame extends JFrame
{
	private final JSplitPane splitPane;
    private final JPanel topPanel;       
    private final JPanel bottomPanel;
	private DiceStatus statusBar;
	
	public DiceFrame(DicePairModel model)
	{
		super("Dice Game Assignment");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		setLayout(new BorderLayout());
		
		setSize(1000, 500);
		
		statusBar = new DiceStatus(model, this);
		
		splitPane = new JSplitPane();
				
		getContentPane().add(splitPane);
		
		topPanel = new DiceDefaultPanel(model, this, statusBar);
		
		bottomPanel = new SummaryPanel(model, statusBar);
		
		/*
		 * Splits the frame into two parts
		 */
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(320);          
        /*
         * topPanel is set to the "Home" panel
         */
        splitPane.setTopComponent(topPanel);  
        /*
         * The bottom panel is set to the Summary Panel
         */
        splitPane.setBottomComponent(bottomPanel);
		
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS)); 
		
		setJMenuBar(new DiceMenu(model, this, statusBar));
						
		setVisible(true);
	}
	
	public JSplitPane getSplitFrame()
	{
		return splitPane;
	}
	
	/*
	 * Method that changes the frame when called after a frame.setTopComponent 
	 * or frame.setBottomComponent
	 */
	public void updatePanel()
	{
		this.getSplitFrame().setDividerLocation(320);
		this.invalidate();
		this.validate();
	}
}
