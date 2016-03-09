package Main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	
	private JFrame frame;
	private JPanel game;
	private static Piece[][] board;
	
	
	public GUI(){

	}
	
	public void initGUI(){
		frame = new JFrame();
		game = new JPanel();
		game.add(board);
		
		frame.setPreferredSize(new Dimension(815, 452));
		frame.setVisible(true);

		//chessBoard.build();
	}
	
	public void fillBoard(){
		
	}
	
	public static void setBoard(Piece[][] submitted){
		board = submitted;
	}
}
