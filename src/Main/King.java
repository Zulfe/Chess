package Main;

public class King extends Piece {

	public King(String ID, String icon, boolean isWhite, char posX, char posY) {
		super(ID, icon, isWhite, posX, posY);
	}

	public boolean isMoveValid(Coordinate newPosition, Piece[][] chessBoard){
		if(Math.abs(super.currentPos.getX() - newPosition.getX()) == 1){
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
		
		if(Math.abs(super.currentPos.getY() - newPosition.getY()) == 1){
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
		
		if(Math.abs(super.currentPos.getX() - newPosition.getX()) == 1 &&
		   Math.abs(super.currentPos.getY() - newPosition.getY()) == 1){
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
