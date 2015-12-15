//================================================================
// AUTHOR:		Kevin Cabrera
// FILENAME:	SelectPanel.java
//================================================================
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SelectPanel extends JPanel{
	JTextArea listArea;
	JButton selectButton;
	JLabel activity;
	JPanel rightPanel;
	ArrayList<String> list;
	
	public SelectPanel(ArrayList<String> list) {
		// declare components
		this.list = list;
		listArea = new JTextArea();
		listArea.setEditable(false);
		activity = new JLabel("Hello");
		selectButton = new JButton("Select Activity");
		rightPanel = new JPanel();
		//System.out.println(this.list.get(0));
		
		// customize right panel 
		rightPanel.setLayout(null);
		rightPanel.add(activity);
		rightPanel.add(selectButton);
		activity.setBounds(100, 100, 100, 100);
		selectButton.setBounds(150, 150, 150, 30);
		
		// customize selectPanel layout
		setLayout(new GridLayout(1, 2));
		add(listArea);
		add(rightPanel);
	}
	
	public void setListArea() {
		listArea.setText("");
		for (int i = 0; i < list.size(); i++)
			listArea.append(list.get(i) + "\n");
	}
}
