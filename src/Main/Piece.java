package Main;

import java.util.ArrayList;

public class Piece {
	
	public String ID;
	protected boolean isWhite;
	protected Coordinate currentPos;
	private int arrayX;
	private int arrayY;
	
	public Piece(String ID, boolean isWhite, char posX, char posY){
		this.ID = ID;
		this.isWhite = isWhite;
		currentPos = new Coordinate(posX, posY);
		arrayX = currentPos.getY();
		arrayY = currentPos.getX();
	}
	
	public int getX(){
		return currentPos.getX();
	}
	
	public int getY(){
		return currentPos.getY();
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
