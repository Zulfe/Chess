package Main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Multiplayer implements ActionListener {
	
	public JButton startGameButton = new JButton();
	private static JButton searchServers;
	private JFrame frame;
	private JPanel panel;
	private JTable table;
	
	public Multiplayer(){
		
	}
	
	public static void broadcastGame(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(searchServers)){
			
		}
	}
	
	
}
