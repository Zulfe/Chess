package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class GUI {
	
	private JFrame frame;
	private JPanel gamePanel;
	private JTable gameBoard;
	private DefaultTableCellRenderer customRender = new BoardCellRenderer();
	private static Piece[][] board;
	
	private final int SQUARE_CELL = 50;
	
	
	public GUI(){

	}
	
	@SuppressWarnings("serial")
	public void initGUI(){
		//allocate the components
		frame = new JFrame();
		gamePanel = new JPanel();
		gameBoard = new BoardTable(){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		//adjust the chessboard's look
		for(int i = 0; i < 8; i++){
			gameBoard.getColumnModel().getColumn(i).setMinWidth(SQUARE_CELL);
			gameBoard.getColumnModel().getColumn(i).setPreferredWidth(SQUARE_CELL);
			gameBoard.getColumnModel().getColumn(i).setMaxWidth(SQUARE_CELL);
			gameBoard.getColumnModel().getColumn(i).setCellRenderer(customRender);
		}
		gameBoard.setRowHeight(SQUARE_CELL);
		gameBoard.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
		gameBoard.setBorder(BorderFactory.createEmptyBorder());
		gameBoard.setIntercellSpacing(new Dimension(0, 0));
		
		//adjust the panel's look
		gamePanel.setBackground(new Color(112, 128, 144));
		
		//put the pieces on the board
		updateBoard();
		
		//fit everything together
		gamePanel.add(gameBoard);
		frame.add(gamePanel);
		
		frame.setMinimumSize(new Dimension(500, 500));
		frame.setVisible(true);
	}
	
	public void updateBoard(){
		for(int i = 0; i < board.length; i++)
			for(int k = 0; k < board[i].length; k++)
				if(board[i][k] != null)
					gameBoard.setValueAt(board[i][k].getIcon(), i, k);
				else
					gameBoard.setValueAt("", i, k);
	}
	
	public static void setBoard(Piece[][] submitted){
		board = submitted;
	}
}
