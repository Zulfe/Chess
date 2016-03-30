package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

public class GUI implements KeyListener {
	
	private JFrame frame;
	private JPanel gamePanel;
	private JTable gameBoard;
	private JTextField textBox;
	private DefaultTableCellRenderer customRender = new BoardCellRenderer();
	private static ChessBoard chessBoard;
	
	private Coordinate movePiece;
	private Coordinate movePosition;
	private volatile boolean isMoveReady = false;
	
	private final int SQUARE_CELL = 80;
	
	
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
		textBox = new JTextField(40);
		
		//adjust the chessboard's look
		for(int i = 0; i < 8; i++){
			gameBoard.getColumnModel().getColumn(i).setMinWidth(SQUARE_CELL);
			gameBoard.getColumnModel().getColumn(i).setPreferredWidth(SQUARE_CELL);
			gameBoard.getColumnModel().getColumn(i).setMaxWidth(SQUARE_CELL);
			gameBoard.getColumnModel().getColumn(i).setCellRenderer(customRender);
		}
		gameBoard.setRowHeight(SQUARE_CELL);
		
		
		try {
			gameBoard.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/MAYAFONT.TTF")).deriveFont(Font.PLAIN, 70));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gameBoard.setBorder(BorderFactory.createEmptyBorder());
		gameBoard.setIntercellSpacing(new Dimension(0, 0));
		
		gameBoard.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gameBoard.addKeyListener(this);
		
		//adjust the panel's look
		gamePanel.setBackground(new Color(112, 128, 144));
		
		//put the pieces on the board
		updateBoard();
		
		//fit everything together
		gamePanel.add(gameBoard);
		gamePanel.add(textBox);
		frame.add(gamePanel);
		
		frame.setMinimumSize(new Dimension(SQUARE_CELL*9, SQUARE_CELL*9));
		frame.setVisible(true);
	}
	
	public void updateBoard(){
		for(int i = 0; i < chessBoard.chessBoard.length; i++)
			for(int k = 0; k < chessBoard.chessBoard[i].length; k++)
				if(chessBoard.chessBoard[i][k] != null)
					gameBoard.setValueAt(chessBoard.chessBoard[i][k].getIcon(), i, k);
				else
					gameBoard.setValueAt("", i, k);
	}
	
	public static void setBoard(ChessBoard board){
		chessBoard = board;
	}

	public Coordinate getMovePiece(){
		return movePiece;
	}
	
	public Coordinate getMovePosition(){
		return movePosition;
	}
	
	public boolean isMoveReady(){
		return isMoveReady;
	}
	
	public void resetMove(){
		movePiece = null;
		movePosition = null;
		isMoveReady = false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			if(movePiece == null){
				System.out.println("Selected piece position: " + gameBoard.getSelectedRow() + ", " + gameBoard.getSelectedColumn());
				movePiece = new Coordinate(gameBoard.getSelectedColumn(), gameBoard.getSelectedRow());
				if(chessBoard.getPieceByPos(movePiece) != null)
					textBox.setText("Player has selected " + chessBoard.getPieceByPos(movePiece).ID + " at (" + movePiece.getGameX() + ", " + movePiece.getGameY() + ")");
			} else{
				System.out.println("Selected move position: " + gameBoard.getSelectedRow() + ", " + gameBoard.getSelectedColumn());
				movePosition = new Coordinate(gameBoard.getSelectedColumn(), gameBoard.getSelectedRow());
				textBox.setText("Player has moved " + chessBoard.getPieceByPos(movePiece).ID + " from (" + movePiece.getGameX() + ", " + movePiece.getGameY() + ") to (" + movePosition.getGameX() + ", " + movePosition.getGameY() + ")");
				isMoveReady = true;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
