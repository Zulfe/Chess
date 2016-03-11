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
		gui.updateBoard();
	}
	
}
