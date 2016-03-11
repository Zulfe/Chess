package Main;

public class Bishop extends Piece {

	public Bishop(String ID, String icon, boolean isWhite, char posX, char posY) {
		super(ID, icon, isWhite, posX, posY);
	}
	
	public boolean isMoveValid(Coordinate newPosition, Piece[][] chessBoard){
		//if the difference in vertical position is the same as the difference in horizontal position
		if((Math.abs(newPosition.getX() - super.currentPos.getX())) == 
		   (Math.abs(newPosition.getY() - super.currentPos.getY()))){
			//and the path is clear
			if(isPathClear(newPosition, chessBoard)){
				//and, if a piece is in the destination square
				if(chessBoard[newPosition.getY()][newPosition.getX()] != null){
					System.out.println("Piece is destination square.");
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
		}
		
		return false;
	}
	
	private boolean isPathClear(Coordinate newPosition, Piece[][] chessBoard){
		//up-right movement
		if((newPosition.getX() > super.currentPos.getX()) && (newPosition.getY() < super.currentPos.getY())){
			for(int i = 1; i < (newPosition.getX() - super.currentPos.getX()); i++){
				if(chessBoard[super.currentPos.getY() - i][super.currentPos.getX() + i] != null){
					System.out.println("Checking to see if (" + (super.currentPos.getY() + i) + ", " + (super.currentPos.getX() - i) + ") is occupied.");
					return false;
				}
			}
		}
		
		//up-left movement
		if((newPosition.getX() < super.currentPos.getX()) && (newPosition.getY() < super.currentPos.getY())){
			for(int i = 1; i < (super.currentPos.getX() - newPosition.getX()); i++){
				if(chessBoard[super.currentPos.getY() - i][super.currentPos.getX() - i] != null){
					System.out.println("Checking to see if (" + (super.currentPos.getY() - i) + ", " + (super.currentPos.getX() - i) + ") is occupied.");
					return false;
				}
			}
		}
		
		//down-right movement
		if((newPosition.getX() > super.currentPos.getX()) && (newPosition.getY() > super.currentPos.getY())){
			for(int i = 1; i < (newPosition.getY() - super.currentPos.getY()); i++){
				if(chessBoard[super.currentPos.getY() + i][super.currentPos.getX() + i] != null){
					System.out.println("Checking to see if (" + (super.currentPos.getY() + i) + ", " + (super.currentPos.getX() + i) + ") is occupied.");
					return false;
				}
			}
		}
		
		//down-left movement
		if((newPosition.getX() < super.currentPos.getX()) && (newPosition.getY() > super.currentPos.getY())){
			for(int i = 1; i < (newPosition.getY() - super.currentPos.getY()); i++){
				if(chessBoard[super.currentPos.getY() + i][super.currentPos.getX() - i] != null){
					System.out.println("Checking to see if (" + (super.currentPos.getY() - i) + ", " + (super.currentPos.getX() + i) + ") is occupied.");
					return false;
				}
			}
		}
		
		
		return true;
	}
}
