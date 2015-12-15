//================================================================
// AUTHOR:		Kevin Cabrera
// FILENAME:	CreatePanel.java
//================================================================
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePanel extends JPanel
{
	private JButton addButton, removeButton, selectButton;
	private JList display;
	private DefaultListModel model;
	private JScrollPane scroll;
	private ArrayList<String> activityList;
	private JTextField field;
	private JLabel label, note, title, direction, resultLabel;
	private File inputFile;
	private PrintWriter out;
	private JPanel buttonPanel, resultPanel, labelPanel;
	private SelectPanel selectPanel;

	public CreatePanel(ArrayList<String> list, SelectPanel selectPanel) throws FileNotFoundException
	{
		this.selectPanel = selectPanel;
		activityList = list;
		title = new JLabel("Things For Us To Do");
		direction = new JLabel("Type in activity");
		label = new JLabel("");
		field = new JTextField(50);
		resultLabel = new JLabel("");
		resultPanel = new JPanel();
		labelPanel = new JPanel();

		// set up JList
		model = new DefaultListModel();
		display = new JList(model);
		scroll = new JScrollPane(display);

		// read file
		inputFile = new File("C:\\Users\\Kevin\\Desktop\\input");
		if (inputFile.isFile() && inputFile.canRead()){
			Scanner in = new Scanner(inputFile);
		while (in.hasNextLine())
		{
			String line = in.nextLine();
			activityList.add(line);
		}
		in.close();
		}
		else 
		{
			saveList();
		}

		if (activityList.size() == 0);
		else 
			setJList();

		// create and modify buttonPanel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		addButton = new JButton("Add");
		removeButton = new JButton("Remove");
		selectButton = new JButton("Select Activity");
		buttonPanel.add(addButton);
		buttonPanel.add(removeButton);

		// edit note
		note = new JLabel("Number of Activities: " + activityList.size());
		note.setForeground(Color.GRAY);
		
		// edit resultPanel
		resultPanel.add(resultLabel);
		
		// edit labelPanel
		labelPanel.add(label);

		// set up the layout
		setLayout(null);
		labelPanel.setBounds(0, 100, 380, 40);
		title.setBounds(67, 20, 260, 50);
		buttonPanel.setBounds(75,270, 250, 30);
		field.setBounds(0, 220, 395, 40);
		scroll.setBounds(395, 0, 247, 468);
		direction.setBounds(5, 200, 150, 15);
		note.setBounds(110, 440, 220, 20);	
		selectButton.setBounds(130, 325, 140, 25);
		// resultLabel.setBounds(185, 350, 200, 100);
		resultPanel.setBounds(103, 365, 200, 100);
		
		// change font and edit preferences
		display.setFont(changeFont("Gabriola", 22));
		resultLabel.setFont(changeFont("Palatino Linotype", 18));
		label.setFont(changeFont("Andalus", 18));
		note.setFont(changeFont("Arial Narrow", 20));
		title.setFont(new Font("Californian FB", Font.PLAIN, 30));
		field.setFont(changeFont("Georgia", 16));
		direction.setFont(changeFont("Baskerville Old Face", 18));
		setForeground(Color.BLUE);

		ActionListener b1 = new ButtonListener();
		addButton.addActionListener(b1);
		removeButton.addActionListener(b1);
		selectButton.addActionListener(b1);

		add(title);
		add(labelPanel);
		add(note);
		add(resultPanel);
		add(field);
		add(scroll);
		add(direction);
		add(buttonPanel);
		add(selectButton);
		
	}

	public Font changeFont(String fontName, int fontSize)
	{
		Font font = new Font(fontName, Font.PLAIN , fontSize);
		return font;
	}

	public void setJList()
	{
		model.clear();
		for (int i = 0; i < activityList.size(); i++)
		{
			model.addElement(i+1 + ") " + activityList.get(i));
		}
		selectPanel.setListArea();
	}

	public void saveList() throws FileNotFoundException
	{
		PrintWriter out = new PrintWriter("C:\\Users\\Kevin\\Desktop\\input");
		for (int i = 0; i < activityList.size(); i++)
			out.println(activityList.get(i));
		out.close();
	}

	public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event){
			if (event.getSource() == addButton)
			{
				boolean addActivity = false;
				String text = field.getText();
				resultLabel.setText("");
				
				if(activityList.size() == 0)
				{
					if (text.equals(""))
					{
						label.setForeground(Color.RED);
						label.setText("No activity was entered");
						addActivity = false;
					}

					else
					{
						label.setForeground(Color.BLUE);
						label.setText("Activity was added");
						activityList.add(text);
						try {
							saveList();
						} 
						catch (FileNotFoundException e) {
						}
						addActivity = true;
					}
				}

				else
				{
					for (int i = 0; i < activityList.size(); i++)
					{
						if (text.equals(""))
						{
							label.setForeground(Color.RED);
							label.setText("No activity was entered");
							addActivity = false;
							break;
						}

						if (text.equals(activityList.get(i)))
						{
							label.setForeground(Color.RED);
							label.setText("Activity already added");
							addActivity = false;
							break;
						}

						if (i == activityList.size()-1)
						{
							label.setForeground(Color.BLUE);
							label.setText("Activity was added");
							activityList.add(text);
							try 
							{
								saveList();
							} 
							catch (FileNotFoundException e) {
							}
							addActivity = true;
							break;
						}
					}
				}

				if (addActivity = true)
				{
					note.setText("Number of Activities: " + activityList.size());
					setJList();
				}
			}

			else if (event.getSource() == removeButton)
			{
				int index = display.getSelectedIndex();
				if (index != -1)
				{
					resultLabel.setText("");
					activityList.remove(index);
					label.setForeground(Color.BLUE);
					label.setText("Activity Removed");
				}
				try 
				{
					saveList();
				} 
				catch (FileNotFoundException e){
				}
				note.setText("Number of Activities: " + activityList.size());
				setJList();
			}
			
			else
			{
				Random generator = new Random();
				int index = generator.nextInt(activityList.size());
				resultLabel.setText(activityList.get(index));
			}
		}
	}
}

