package Main;

public class Pawn extends Piece {

	public Pawn(String ID, String icon, boolean isWhite, char posX, char posY) {
		super(ID, icon, isWhite, posX, posY);
	}
	
	public boolean isMoveValid(Coordinate newPosition, Piece[][] chessBoard){
		if(super.isWhite){
			
			//capture
			//if the new move is not on the same axis as the pawn
			if(newPosition.getX() != super.currentPos.getX()){
				//but is within one column of the pawn
				if(Math.abs(super.currentPos.getX() - newPosition.getX()) == 1){
					//and is in front of the pawn
					if(super.currentPos.getY() - newPosition.getY() == 1){
						//and a BLACK piece is in the capture square
						if((chessBoard[newPosition.getY()][newPosition.getX()] != null) &&
						   !(chessBoard[newPosition.getY()][newPosition.getX()].isWhite)){
							return true;
						}
					}
				}
			}
			
			//first move double jump
			//if the player is attempting to move on the same axis
			if(newPosition.getX() == super.currentPos.getX()){
				//and the player is attempting to move two spaces forward
				if(newPosition.getY() == 4){
					//and the pawn is in its initial position
					if(super.currentPos.getY() == 6){
						//and nothing occupies that spot (pawns can't capture on forward jump)
						if(chessBoard[newPosition.getY()][newPosition.getX()] == null){
							//and the pawn is not jumping over another piece
							if(chessBoard[5][newPosition.getX()] == null){
								return true;
							}
						}
					}
				}
			}
			
			//single jump
			//if the player is attempting to move one space forward
			if(super.currentPos.getY() - newPosition.getY() == 1){
				//and the new position is on the same x-axis as the current position
				if(super.currentPos.getX() == newPosition.getX()){
					//and nothing occupies that spot
					if(chessBoard[newPosition.getY()][newPosition.getX()] == null){
						return true;
					}
				}
			}
				
			//if the player's attempted move doesn't follow the pawn's movement rules, disallow the move
			return false;
		}
		//*****************
		//black pawn motion
		//*****************
		else{
			
			//capture
			//if the new move is not on the same axis as the pawn
			if(newPosition.getX() != super.currentPos.getX()){
				//but is within one column of the pawn
				if(Math.abs(super.currentPos.getX() - newPosition.getX()) == 1){
					//and is in front of the pawn
					if(newPosition.getY() - super.currentPos.getY() == 1){
						//and a BLACK piece is in the capture square
						if((chessBoard[newPosition.getY()][newPosition.getX()] != null) &&
						   (chessBoard[newPosition.getY()][newPosition.getX()].isWhite)){
							return true;
						}
					}
				}
			}
			
			//first move double jump
			//if the player is attempting to move on the same axis
			if(newPosition.getX() == super.currentPos.getX()){
				//and the player is attempting to move two spaces forward
				if(newPosition.getY() == 3){
					//and the pawn is in its initial position
					if(super.currentPos.getY() == 1){
						//and nothing occupies that spot (pawns can't capture on forward jump)
						if(chessBoard[newPosition.getY()][newPosition.getX()] == null){
							//and the pawn is not jumping over another piece
							if(chessBoard[2][newPosition.getX()] == null){
								return true;
							}
						}
					}
				}
			}
			
			//single jump
			//if the player is attempting to move one space forward
			if(newPosition.getY() - super.currentPos.getY() == 1){
				//and the new position is on the same x-axis as the current position
				if(super.currentPos.getX() == newPosition.getX()){
					//and nothing occupies that spot
					if(chessBoard[newPosition.getY()][newPosition.getX()] == null){
						return true;
					}
				}
			}
			
			
			return false;
		}
	}

}
