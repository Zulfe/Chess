package Main;

public class Coordinate {
	
	private int posX;
	private int posY;
	private char gameX;
	private char gameY;
	
	public Coordinate(){
		
	}
	
	public Coordinate(char posX, char posY){
		this.posX = interpretCoordinate(posX);
		this.posY = interpretCoordinate(posY);
		this.gameX = posX;
		this.gameY = posY;
	}
	
	public Coordinate(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
		this.gameX = interpretIntCoordAsGame(posX, 'X');
		this.gameY = interpretIntCoordAsGame(posY, 'Y');
	}
	
	/**
	 * Interprets a given Character value as an Integer following the board's
	 * representation as a 2-D array.
	 * @param coordinate the character value for either axis at that position (A-H, 1-8)
	 * @return the integer value for the 2-D array (0-7)
	 */
	public int interpretCoordinate(char coordinate){
		System.out.println("Interpreting coordinate " + coordinate);
		int numeralCoord = (int) ChessBoard.coordinateMap.get(coordinate);
		return numeralCoord;
	}
	
	/**
	 * Interprets a given Integer value as a Character following chess's modern commentary.
	 * An axis must be specified as either X or Y for the proper result.
	 * @param coordinate the integer value for the position on that axis (0-7)
	 * @param axis
	 * @return the character for that position (A-H, 1-8)
	 */
	public char interpretIntCoordAsGame(int coordinate, char axis){
		if(axis == 'X' || axis == 'x'){
			return (char) (coordinate + 65);
		} else {
			return (char) (8 - coordinate + 48);
		}
	}
	
	/**
	 * Returns the position along the x-axis as an Integer value.
	 * @return the position along the x-axis
	 */
	public int getX(){
		return posX;
	}
	
	/**
	 * Returns the position along the y-axis as an Integer value.
	 * @return the position along the y-axis
	 */
	public int getY(){
		return posY;
	}
	
	/**
	 * Returns the position along the x-axis as a Character following chess's modern commentary.
	 * @return the position along the x-axis
	 */
	public char getGameX(){
		return gameX;
	}
	
	/**
	 * Returns the position along the y-axis as a Character following chess's modern commentary.
	 * @return the position along the y-axis
	 */
	public char getGameY(){
		return gameY;
	}
	
	/**
	 * Returns the Coordinate object as an integral coordinate set, such as (0,4).
	 */
	public String toString(){
		return "(" + posX + ", " + posY + ")";
	}

}
