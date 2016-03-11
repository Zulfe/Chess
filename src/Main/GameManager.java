package Main;

import java.awt.FontFormatException;
import java.io.IOException;

public class GameManager {
	
	private ChessBoard board;
	private GUI gui;
	
	public GameManager(){
		
	}
	
	public void startGame() throws FontFormatException, IOException{
		board = new ChessBoard();
		gui = new GUI();
		board.build();
		board.printBoard();
		board.sendBoardToGUI();
		gui.initGUI();
		board.movePiece(board.getPieceByID("WK2"), new Coordinate('A', '3'));
		board.movePiece(board.getPieceByID("WP7"), new Coordinate('B', '3'));
		board.movePiece(board.getPieceByID("WK2"), new Coordinate('C', '4'));
		board.movePiece(board.getPieceByID("WK2"), new Coordinate('A', '5'));
		gui.updateBoard();
		
	}
	
}
