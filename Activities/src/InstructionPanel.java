//==================================================================
// AUTHOR:		Kevin Cabrera
// FILENAME:	InstructionPanel.java
// DESCRIPTION:	Sets the layout of the instruction panel of the GUI.
//				The instruction panel is assigned its own tab.
//==================================================================
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InstructionPanel extends JPanel
{
	JLabel addLabel, removeLabel, selectLabel;
	
	public InstructionPanel()
	{
		addLabel = new JLabel("Add: To add an activity to the list first type in the activity and hit \"Add\"", SwingConstants.CENTER);
		removeLabel = new JLabel("Remove: To remove an activity from the list first click on the activity and then hit \"Remove\"", SwingConstants.CENTER);
		selectLabel = new JLabel("Select Activity: Randomly selects an activity from the list.", SwingConstants.CENTER);
		
		//set font of labels
		addLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		removeLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		selectLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		
		//add components to panel
		setLayout(new GridLayout(3, 1));
		add(addLabel);
		add(removeLabel);
		add(selectLabel);
		
	}
}
