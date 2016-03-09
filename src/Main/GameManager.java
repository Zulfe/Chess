package Main;

public class GameManager {
	
	private ChessBoard board;
	//test
	public GameManager(){
		
	}
	
	public void startGame(){
		board = new ChessBoard();
		board.build();
		board.printBoard();
		board.movePiece(board.getPieceByID("WP8"), new Coordinate('A', '4'));
		board.printBoard();
		board.movePiece(board.getPieceByID("WP8"), new Coordinate('A', '5'));
		board.printBoard();
		board.sendBoardToGUI();
	}
	
}
