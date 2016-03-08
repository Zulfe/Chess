package Main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	
	// 8x8 table
	private ChessBoard chessBoard = new ChessBoard() {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column){
			return false;
		};
	};
	
	private JFrame frame;
	private JPanel game;
	
	
	
	public GUI(){
		
	}
	
	public void initGUI(){
		chessBoard.build();
		frame = new JFrame();
		game = new JPanel();
		game.add(chessBoard);
		
		frame.setPreferredSize(new Dimension(815, 452));
		frame.setVisible(true);

		//chessBoard.build();
	}
}
