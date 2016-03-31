package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Handlers.ButtonHandler;

public class GameManager {
	
	private ChessBoard board;
	private GUI gui;
	private Multiplayer mp;
	private ButtonHandler bh;
	
	public GameManager(){
		board = new ChessBoard();
		gui = new GUI(board);
		mp = new Multiplayer();
	}
	
	public void startGUI(){
		gui.initGUI();
	}
	
	public void startGame() throws IOException{
		while(true){
			if(gui.isMoveReady()){
				System.out.println("MOVE READY!");
				board.movePiece(board.getPieceByPos(gui.getMovePiece()), gui.getMovePosition());
				gui.resetMove();
				gui.updateBoard();
			}
		}
	}
	
	public void multiplayerStart(){
		board.build();
		gui.updateBoard();
	}
}
