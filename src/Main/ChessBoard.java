package Main;

import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ChessBoard {
	
	Piece[][] chessBoard;
	public static HashMap<Character, Integer> coordinateMap;
	
	public ChessBoard(){
		coordinateMap = new HashMap<Character, Integer>();	
		coordinateMap.put('A', 0);
		coordinateMap.put('B', 1);
		coordinateMap.put('C', 2);
		coordinateMap.put('D', 3);
		coordinateMap.put('E', 4);
		coordinateMap.put('F', 5);
		coordinateMap.put('G', 6);
		coordinateMap.put('H', 7);
		coordinateMap.put('8', 0);
		coordinateMap.put('7', 1);
		coordinateMap.put('6', 2);
		coordinateMap.put('5', 3);
		coordinateMap.put('4', 4);
		coordinateMap.put('3', 5);
		coordinateMap.put('2', 6);
		coordinateMap.put('1', 7);
	}

	// builds new chess board where white is on bottom, black is on top
	public void build(){
		chessBoard = new Piece[8][8];
		
		//black pieces
		chessBoard[0][0] = new Rooke("BR1", "t", false, 'A', '8');
		chessBoard[0][1] = new Knight("BK1", "m", false, 'B', '8');
		chessBoard[0][2] = new Bishop("BB1", "v", false, 'C', '8');
		chessBoard[0][3] = new Queen("BQu", "w", false, 'D', '8');
		chessBoard[0][4] = new King("BKi", "l", false, 'E', '8');
		chessBoard[0][5] = new Bishop("BB2", "v", false, 'F', '8');
		chessBoard[0][6] = new Knight("BK2", "m", false, 'G', '8');
		chessBoard[0][7] = new Rooke("BR2", "t", false, 'H', '8');
		chessBoard[1][0] = new Pawn("BP1", "o", false, 'A', '7');
		chessBoard[1][1] = new Pawn("BP2", "o", false, 'B', '7');
		chessBoard[1][2] = new Pawn("BP3", "o", false, 'C', '7');
		chessBoard[1][3] = new Pawn("BP4", "o", false, 'D', '7');
		chessBoard[1][4] = new Pawn("BP5", "o", false, 'E', '7');
		chessBoard[1][5] = new Pawn("BP6", "o", false, 'F', '7');
		chessBoard[1][6] = new Pawn("BP7", "o", false, 'G', '7');
		chessBoard[1][7] = new Pawn("BP8", "o", false, 'H', '7');
		
		//white pieces
		chessBoard[7][0] = new Rooke("WR2", "r", true, 'A', '1');
		chessBoard[7][1] = new Knight("WK2", "n", true, 'B', '1');
		chessBoard[7][2] = new Bishop("WB2", "b", true, 'C', '1');
		chessBoard[7][3] = new Queen("WQu", "q", true, 'D', '1');
		chessBoard[7][4] = new King("WKi", "k", true, 'E', '1');
		chessBoard[7][5] = new Bishop("WB1", "b", true, 'F', '1');
		chessBoard[7][6] = new Knight("WK1", "n", true, 'G', '1');
		chessBoard[7][7] = new Rooke("WR1", "r", true, 'H', '1');
		chessBoard[6][0] = new Pawn("WP8", "p", true, 'A', '2'); 
		chessBoard[6][1] = new Pawn("WP7", "p", true, 'B', '2');
		chessBoard[6][2] = new Pawn("WP6", "p", true, 'C', '2');
		chessBoard[6][3] = new Pawn("WP5", "p", true, 'D', '2');
		chessBoard[6][4] = new Pawn("WP4", "p", true, 'E', '2');
		chessBoard[6][5] = new Pawn("WP3", "p", true, 'F', '2');
		chessBoard[6][6] = new Pawn("WP2", "p", true, 'G', '2');
		chessBoard[6][7] = new Pawn("WP1", "p", true, 'H', '2');
	}
	
	public void movePiece(Piece piece, Coordinate newPosition){
		if(piece.isMoveValid(newPosition, chessBoard)){
			Piece pieceCopy = piece;
			chessBoard[newPosition.getY()][newPosition.getX()] = pieceCopy;
			chessBoard[piece.getY()][piece.getX()] = null;
			piece.updatePosition(newPosition);
			System.out.println(piece.ID + " has been moved to " + newPosition);
		} else{
			System.out.println("Invalid move request for " + piece.ID);
		}
	}
	
	public Piece getPieceByID(String ID){
		for(Piece[] row : chessBoard)
			for(Piece piece : row)
				if(piece != null && piece.ID == ID)
					return piece;
		return null;
	}
	
	public void printBoard(){
		for(int i = 0; i < 8; i++)
			for(int k = 0; k < 8; k++)
				System.out.println(chessBoard[i][k]);
	}
	
	public void sendBoardToGUI(){
		GUI.setBoard(chessBoard);
	}
	
	//BOARD LAYOUT
	//[BR1][BK1][BB1][BQu][BKi][BB2][BK2][BR2]
	//[BP1][BP2][BP3][BP4][BP5][BP6][BP7][BP8]
	//[Emp][Emp][Emp][Emp][Emp][Emp][Emp][Emp]
	//[Emp][Emp][Emp][Emp][Emp][Emp][Emp][Emp]
	//[Emp][Emp][Emp][Emp][Emp][Emp][Emp][Emp]
	//[Emp][Emp][Emp][Emp][Emp][Emp][Emp][Emp]
	//[WP8][WP7][WP6][WP5][WP4][WP3][WP2][WP1]
	//[WR2][WK2][WB2][WKi][WQu][WB1][WK1][WR1]
}