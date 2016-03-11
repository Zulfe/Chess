package Main;

import java.awt.FontFormatException;
import java.io.IOException;

public class Main {
	
	private static GUI GUI = new GUI();
	
	public static void main(String[] args) throws FontFormatException, IOException{
		GameManager gm = new GameManager();
		gm.startGame();
	}
}
