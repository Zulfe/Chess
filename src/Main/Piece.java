package Main;

public class Piece {
	
	public String ID;
	protected boolean isWhite;
	protected Coordinate currentPos;
	protected String icon;
	
	public Piece(String ID, String icon, boolean isWhite, char posX, char posY){
		this.ID = ID;
		this.icon = icon;
		this.isWhite = isWhite;
		currentPos = new Coordinate(posX, posY);
	}
	
	/**
	 * This is constructor should not be used for creating pieces that are to be
	 * placed on the board. This constructor is merely used by the Queen class
	 * to create instances of a Rooke and a Bishop to use the combination of
	 * movement criterias as its own.
	 */
	public Piece(){
		
	}
	
	/**
	 * Returns the position along the x-axis for this piece as an Integer value.
	 * @return the position along the x-axis
	 */
	public int getX(){
		return currentPos.getX();
	}
	
	/**
	 * Returns the position along the y-axis for this piece as an Integer value.
	 * @return the position along the y-axis
	 */
	public int getY(){
		return currentPos.getY();
	}
	
	/**
	 * Returns the icon assigned for this piece as a String object.
	 * @return the icon
	 */
	public String getIcon(){
		return icon;
	}
	
	/**
	 * Checks the movement criteria for this piece to determine if the specified
	 * location is a valid place to move to.
	 * @param newPosition the place where the piece is to be moved
	 * @param chessBoard the current state of the chessboard
	 * @return a boolean stating whether the move is valid or is not valid
	 */
	public boolean isMoveValid(Coordinate newPosition, Piece[][] chessBoard) {
		return false;
	}

	public void updatePosition(Coordinate newPosition){
		currentPos = newPosition;
	}
	
	public String toString(){
		//ARRAY coordinates inverted since [y][x] in tables.
		return "Piece " + ID + " at ARRAY: (" + currentPos.getY() + ", " + currentPos.getX() + ") COORD: " + currentPos + " GAME: (" + currentPos.getGameX() + ", " + currentPos.getGameY() + ") (White? " + isWhite +")";
	}

}
