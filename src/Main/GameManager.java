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
		board.movePiece(board.getPieceByID("WP4"), new Coordinate('E', '3'));
		board.movePiece(board.getPieceByID("WQu"), new Coordinate('F', '3'));
		board.movePiece(board.getPieceByID("WQu"), new Coordinate('F', '5'));
		gui.updateBoard();
	}
	
}
