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
	
	public void openGUI(){
		frame = new JFrame();
		panel = new JPanel();
		table = new JTable(4, 1);
		searchServers = new JButton("Search for Servers");
		JLabel loading = new JLabel(new ImageIcon("resources/images/loading.gif"));
		
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setMinWidth(200);
		
		panel.setPreferredSize(new Dimension(250, 200));
		
		panel.add(table);
		panel.add(searchServers);
		panel.add(loading);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(searchServers)){
			
		}
	}
	
	
}
