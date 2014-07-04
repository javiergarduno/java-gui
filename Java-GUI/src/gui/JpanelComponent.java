package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JpanelComponent extends JPanel {
	
	private JTextArea logArea = new JTextArea(18, 100);
	JButton actionButton = new JButton("Accion");
	
	//... Create components (but without listeners)
    JButton north  = new JButton("North");
    JButton east   = new JButton("East");
    JButton south  = new JButton("South");
    JButton west   = new JButton("West");
    JButton center = new JButton("Center");
	
	JpanelComponent(){
		
		for (int i = 0; i < 200; i++) {			
			logArea.append("linea: " + i + "\n");
		}
        //... Create content pane, set layout, add components
       setLayout(new BorderLayout());
       setLayout(new BoxLayout(this,BoxLayout.X_AXIS));


       JScrollPane jp = new JScrollPane(logArea);
       actionButton.setSize(10, 10);
       
        add(north , BorderLayout.NORTH);
        add(east  , BorderLayout.EAST);
        add(west  , BorderLayout.WEST);
        add(actionButton, BorderLayout.SOUTH);
        add(jp, BorderLayout.CENTER);		
	}
	
	/**
	 * @param text
	 * @return Appends text with date to JPanel
	 */
	public void writeLog(String text){
        logArea.append("\n" + text);

	}
	

}
