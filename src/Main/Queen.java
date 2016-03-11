package Main;

public class Queen extends Piece {

	private Bishop bishopReferenceWhite;
	private Rooke rookeReferenceWhite;
	private Bishop bishopReferenceBlack;
	private Rooke rookeReferenceBlack;
	
	public Queen(String ID, String icon, boolean isWhite, char posX, char posY) {
		super(ID, icon, isWhite, posX, posY);
		bishopReferenceWhite = new Bishop("QuB", "X", true, posX, posY);
		rookeReferenceWhite = new Rooke("QuR", "X", true, posX, posY);
		bishopReferenceBlack = new Bishop("QuB", "X", false, posX, posY);
		rookeReferenceBlack = new Rooke("QuR", "X", false, posX, posY);
	}
	
	public boolean isMoveValid(Coordinate newPosition, Piece[][] chessBoard){
		//if the queen's motion meets the criteria for the motion of either a rooke
		//or a bishop, allow the move
		if(super.isWhite){
			if(bishopReferenceWhite.isMoveValid(newPosition, chessBoard)){
				bishopReferenceWhite.updatePosition(newPosition);
				rookeReferenceWhite.updatePosition(newPosition);
				return true;
			}
			if(rookeReferenceWhite.isMoveValid(newPosition, chessBoard)){
				bishopReferenceWhite.updatePosition(newPosition);
				rookeReferenceWhite.updatePosition(newPosition);
				return true;
			}
		}
		else{
			if(bishopReferenceBlack.isMoveValid(newPosition, chessBoard)){
				bishopReferenceBlack.updatePosition(newPosition);
				rookeReferenceBlack.updatePosition(newPosition);
				return true;
			}
			if(rookeReferenceBlack.isMoveValid(newPosition, chessBoard)){
				bishopReferenceBlack.updatePosition(newPosition);
				rookeReferenceBlack.updatePosition(newPosition);
				return true;
			}
		}
		return false;
	}
}
