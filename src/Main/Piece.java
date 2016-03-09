package Main;

import java.util.ArrayList;

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
	
	public int getX(){
		return currentPos.getX();
	}
	
	public int getY(){
		return currentPos.getY();
	}
	
	public String getIcon(){
		return icon;
	}
	
	public String toString(){
		//ARRAY coordinates inverted since [y][x] in tables.
		return "Piece " + ID + " at ARRAY: (" + currentPos.getY() + ", " + currentPos.getX() + ") COORD: " + currentPos + " GAME: (" + currentPos.getGameX() + ", " + currentPos.getGameY() + ") (White? " + isWhite +")";
	}

	public boolean isMoveValid(Coordinate newPosition, Piece[][] chessBoard) {
		return false;
	}

	public void updatePosition(Coordinate newPosition){
		currentPos = newPosition;
	}
}
