package gui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class windowFrame extends JFrame{
	TrayIcon trayIcon;
	SystemTray tray;
	
	JpanelComponent panel;
	JpanelComponent panel2;

	
	windowFrame(){
		super("Windows Title");

		System.out.println("creating instance");
		
		try{
			System.out.println("setting look and feel");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){
			System.out.println("Unable to set LookAndFeel");
		}

		if(SystemTray.isSupported()){
			System.out.println("system tray supported");
			tray = SystemTray.getSystemTray();

			Image image = Toolkit.getDefaultToolkit().getImage("image.png");			

			ActionListener exitListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Exiting....");
					System.exit(0);
				}
			};

			PopupMenu popup = new PopupMenu();
			
			MenuItem defaultItem = new MenuItem("Cerrar");
			defaultItem.addActionListener(exitListener);
			popup.add(defaultItem);

			defaultItem = new MenuItem("Abrir");
			defaultItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(true);
					setExtendedState(JFrame.NORMAL);
				}
			});
			popup.add(defaultItem);			
			
			trayIcon = new TrayIcon(image, "Copia de Fuentes", popup);
			trayIcon.setImageAutoSize(true);			
			
		}else{
			System.out.println("system tray not supported");
		}

		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
				if(e.getNewState()==ICONIFIED){
					try {
						tray.add(trayIcon);
						setVisible(false);
						System.out.println("added to SystemTray");
					} catch (AWTException ex) {
						System.out.println("unable to add to tray");
					}
				}
				if(e.getNewState()==7){
					try{
						tray.add(trayIcon);
						setVisible(false);
						System.out.println("added to SystemTray");
					}catch(AWTException ex){
						System.out.println("unable to add to system tray");
					}
				}
				if(e.getNewState()==MAXIMIZED_BOTH){
					tray.remove(trayIcon);
					setVisible(true);
					System.out.println("Tray icon removed");
				}
				if(e.getNewState()==NORMAL){
					tray.remove(trayIcon);
					setVisible(true);
					System.out.println("Tray icon removed");
				}
			}
		});
				
		setIconImage(Toolkit.getDefaultToolkit().getImage("image.png"));

		
		
		
		panel =  new JpanelComponent();
        add(panel);
		
		//Set window characteristics.
		setVisible(true);
		//Set default size
		//setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
        
	}

	
}