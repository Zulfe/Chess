package Main;

public class Knight extends Piece {

	public Knight(String ID, String icon, boolean isWhite, char posX, char posY) {
		super(ID, icon, isWhite, posX, posY);
	}
		
	public boolean isMoveValid(Coordinate newPosition, Piece[][] chessBoard){
		//vertical movement
		if( (Math.abs(newPosition.getX() - super.currentPos.getX()) == 1) &&
			(Math.abs(newPosition.getY() - super.currentPos.getY()) == 2)){
				if(chessBoard[newPosition.getY()][newPosition.getX()] != null){
					//and it is not the same color as the moving piece
					if(chessBoard[super.currentPos.getY()][super.currentPos.getX()].isWhite != 
							   chessBoard[newPosition.getY()][newPosition.getX()].isWhite){
						return true;
					}
				}
				//or if a piece is not in the destination square, allow the move
				else{
					return true;
				}
		}
		//horizontal movement
		if( (Math.abs(newPosition.getX() - super.currentPos.getX()) == 2) &&
			(Math.abs(newPosition.getY() - super.currentPos.getY()) == 1)){
				//if there is a piece in the destination square
				if(chessBoard[newPosition.getY()][newPosition.getX()] != null){
					//and it is not the same color as the moving piece
					if(chessBoard[super.currentPos.getY()][super.currentPos.getX()].isWhite != 
					   chessBoard[newPosition.getY()][newPosition.getX()].isWhite){
						return true;
					}
				}
				//or if a piece is not in the destination square, allow the move
				else{
					return true;
				}
		}
		return false;
	}
}
