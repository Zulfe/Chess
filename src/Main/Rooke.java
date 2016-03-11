package Main;

public class Rooke extends Piece {

	public Rooke(String ID, String icon, boolean isWhite, char posX, char posY) {
		super(ID, icon, isWhite, posX, posY);
	}

	public boolean isMoveValid(Coordinate newPosition, Piece[][] chessBoard){
		//vertical motion
		//if the player is trying to move along the y-axis
		if(newPosition.getX() == super.currentPos.getX()){
			//and there aren't any pieces in the way
			System.out.println("CHECKING IF ROOKE PATH IS CLEAR!");
			if(isPathClearY(newPosition, chessBoard)){
				//and, if a piece is in the destination square
				if(chessBoard[newPosition.getY()][newPosition.getX()] != null){
					//and it is not white
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
		}
		
		//horizontal motion
		//if the player is trying to move along the x-axis
		if(newPosition.getY() == super.currentPos.getY()){
			//and there aren't any pieces in the way
			if(isPathClearX(newPosition, chessBoard)){
				//and, if a piece is in the destination square
				if(chessBoard[newPosition.getY()][newPosition.getX()] != null){
					//and it is not the same color as the piece moving
					if(chessBoard[super.currentPos.getY()][super.currentPos.getX()] != 
					   chessBoard[newPosition.getY()][newPosition.getX()]){
						return true;
					}
				}
				//or if a piece is not in the destination square, allow the move
				else{
					return true;
				}
			}
		}
		
		//if the move does not meet the rooke's criteria, disallow the move
		return false;
	}
	
	//evaluates a given x-axis
	//go through each square between the current position and destination; if there
	//is a piece anywhere, disallow the move
	private boolean isPathClearY(Coordinate newPosition, Piece[][] chessBoard){
		//upward motion
		if(super.currentPos.getY() > newPosition.getY()){
			for(int i = super.currentPos.getY() - 1; i > newPosition.getY(); i--){
				System.out.println("Checking to see if (" + super.currentPos.getX() + ", " + i + ") is occupied.");
				if(chessBoard[i][super.currentPos.getX()] != null) return false;
			}
		}
		
		//downward motion
		if(newPosition.getY() > super.currentPos.getY()){
			for(int i = super.currentPos.getY() + 1; i < newPosition.getY(); i++){
				System.out.println("Checking to see if (" + super.currentPos.getX() + ", " + i + ") is occupied.");
				if(chessBoard[i][super.currentPos.getX()] != null) return false;
			}
		}
		
		//if there's nothing in the way, allow the move
		return true;
	}
	
	//evaluate a given y-axis
	public boolean isPathClearX(Coordinate newPosition, Piece[][] chessBoard){
		//leftward motion
		if(super.currentPos.getX() > newPosition.getX()){
			for(int i = super.currentPos.getX() - 1; i > newPosition.getX(); i--){
				System.out.println("Checking to see if (" + super.currentPos.getX() + ", " + i + ") is occupied.");
				if(chessBoard[super.currentPos.getY()][i] != null) return false;
			}
		}
		
		//rightward motion
		if(newPosition.getX() > super.currentPos.getX()){
			for(int i = super.currentPos.getX() + 1; i < newPosition.getX(); i++){
				System.out.println("Checking to see if (" + i + ", " + super.currentPos.getY() + ") is occupied.");
				if(chessBoard[super.currentPos.getY()][i] != null) return false;
			}
		}
		
		//if there's nothing in the way, allow the move
		return true;
	}
	
}
