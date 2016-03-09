package Main;

public class GameManager {
	
	private ChessBoard board;
	private GUI gui;
	
	public GameManager(){
		
	}
	
	public void startGame(){
		board = new ChessBoard();
		gui = new GUI();
		board.build();
		board.printBoard();
		board.sendBoardToGUI();
		gui.initGUI();
		board.movePiece(board.getPieceByID("WP7"), new Coordinate('B', '4'));
		gui.updateBoard();
	}
	
}
