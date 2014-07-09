package gui;

import javax.swing.JFrame;

public class UserInterface {

	public static void main(String[] args) {
		
		//Create a window
		WindowTray frame =  new WindowTray();
		
		//create panels
		JpanelComponent panel =  new JpanelComponent();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();

	}

}
