//================================================================
// AUTHOR:		Kevin Cabrera
// FILENAME:	main.java
// DESCRIPTION:	This GUI displays and stores a list of activities
//				entered by the user. At termination of the program
//				the list is saved.
//				NOTE: Be sure to override the path specified in 
//				lines 45 and 141 of the CreatePanel class. This is
//				where your list will be saved.
//================================================================

import javax.swing.*;
import java.io.*;
import java.util.*;

public class main extends JFrame
{
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<String> list = new ArrayList<String>();
		
		// instantiate the components of the frame
		InstructionPanel instructionPanel = new InstructionPanel();
		SelectPanel selectPanel = new SelectPanel(list);
		CreatePanel createPanel = new CreatePanel(list, selectPanel);
		JTabbedPane tPane = new JTabbedPane();
	
		// add components to tabs
		tPane.addTab("Add List", createPanel);
		//tPane.addTab("Select Activity", selectPanel);
		tPane.addTab("Instructions", instructionPanel);
		
		// instantiate and customize frame
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		frame.setSize(650,500);
		frame.setTitle("Activities");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(tPane);
		frame.setVisible(true);
	}
}

