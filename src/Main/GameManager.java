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
		board.movePiece(board.getPieceByID("WP8"), new Coordinate('A', '4'));
		board.movePiece(board.getPieceByID("BP8"), new Coordinate('H', '5'));
		board.movePiece(board.getPieceByID("BR2"), new Coordinate('H', '6'));
		board.movePiece(board.getPieceByID("BR2"), new Coordinate('A', '6'));
		board.movePiece(board.getPieceByID("BR2"), new Coordinate('A', '4'));
		gui.updateBoard();
	}
	
}
