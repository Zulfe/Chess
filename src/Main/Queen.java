package Main;

public class Queen extends Piece {

	private Bishop bishopReference;
	private Rooke rookeReference;
	
	public Queen(String ID, String icon, boolean isWhite, char posX, char posY) {
		super(ID, icon, isWhite, posX, posY);
		bishopReference = new Bishop("QuB", "X", true, posX, posY);
		rookeReference = new Rooke("QuR", "X", true, posX, posY);
	}
	
	public boolean isMoveValid(Coordinate newPosition, Piece[][] chessBoard){
		if(rookeReference.isMoveValid(newPosition, chessBoard) || bishopReference.isMoveValid(newPosition, chessBoard)){
			return true;
		}
		return false;
	}
	

}
