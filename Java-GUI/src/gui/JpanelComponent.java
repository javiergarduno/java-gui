package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class JpanelComponent extends JPanel {

	JpanelComponent(){
		final JTextArea chatArea = new JTextArea(8, 40);
		chatArea.setEditable(false);
		chatArea.setFocusable(false);
		JScrollPane chatScroll = new JScrollPane(chatArea);

		JPanel chatPanel = new JPanel(new BorderLayout());
		chatPanel.add(new JLabel("Chat:", SwingConstants.LEFT), BorderLayout.PAGE_START);
		chatPanel.add(chatScroll);

		//------ second panel
		final JTextField inputField = new JTextField(40);
		JButton sendBtn = new JButton("Send");
		JButton exitBtn = new JButton("Exit"); 

		//buttons action events
		sendBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){				
				chatArea.append("TU:\n " + inputField.getText() + "\n");	
			}
		}
				);

		exitBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){				
				inputField.setText("");
				chatArea.setText("Adios!!!");	
			}
		}
				);


		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.LINE_AXIS));
		inputPanel.add(inputField);
		inputPanel.add(sendBtn);
		inputPanel.add(exitBtn);

		// ---- third panel 
		JPanel youLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		youLabelPanel.add(new JLabel("You:"));

		// --- main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.add(chatPanel);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(youLabelPanel);
		mainPanel.add(inputPanel);

		add(mainPanel);
	}
}
