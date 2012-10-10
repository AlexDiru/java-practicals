package practicalWeek1.task2;

import javax.swing.*;

public class Main {

	//Returns the first letter of each word as a string
	public static String getInitials(String name) {
		String[] words = name.split("\\ "); //Split by space
		String initials = new String();
		
		//Get the first character of each string and add to initials
		for (String word : words)
			if (word.length() > 0)
				initials += word.charAt(0);
		
		return initials;
	}
	
	public static void main(String[] args) {
		
		//Set the UI to something less grim than default Swing
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Get the user's input - their name
		String name = JOptionPane.showInputDialog(null, "Please enter your name");
		JOptionPane.showMessageDialog(null, "Your initials are " + getInitials(name));
	}

}
