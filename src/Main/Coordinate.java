package Main;

import java.util.HashMap;

public class Coordinate {
	
	private int posX;
	private int posY;
	private char gameX;
	private char gameY;
	
	public Coordinate(){
		
	}
	
	
	//Sets the coordinates to the piece's initial position.
	//Interprets both axes.
	//Builds the coordinate map for later use.
	public Coordinate(char posX, char posY){
		this.posX = interpretCoordinate(posX);
		this.posY = interpretCoordinate(posY);
		this.gameX = posX;
		this.gameY = posY;
	}
	
	public int interpretCoordinate(char coordinate){
		System.out.println("Interpreting coordinate " + coordinate);
		int numeralCoord = (int) ChessBoard.coordinateMap.get(coordinate);
		return numeralCoord;
	}
	
	//returns an integer value for the position along the x-axis
	public int getX(){
		return posX;
	}
	
	//returns an integer value for the position along the y-axis
	public int getY(){
		return posY;
	}
	
	//returns a character value for human interpretation for the position along the x-axis
	public char getGameX(){
		return gameX;
	}
	
	//returns a character value for human interpretation for the position along the y-axis
	public char getGameY(){
		return gameY;
	}
	
	public String toString(){
		return "(" + posX + ", " + posY + ")";
	}

}
