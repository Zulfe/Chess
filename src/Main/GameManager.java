package Main;

import java.awt.FontFormatException;
import java.io.IOException;

public class GameManager {
	
	private ChessBoard board;
	private GUI gui;
	
	public GameManager(){
		
	}
	
	public void startGame() throws IOException{
		board = new ChessBoard();
		gui = new GUI();
		board.build();
		board.sendBoardToGUI();
		gui.initGUI();
		while(true){
			if(gui.isMoveReady()){
				System.out.println("MOVE READY!");
				board.movePiece(board.getPieceByPos(gui.getMovePiece()), gui.getMovePosition());
				gui.resetMove();
				gui.updateBoard();
			}
		}
		
		
	}
	
}
