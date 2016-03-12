package Main;

import java.io.IOException;

public class Main {
	
	private static GUI GUI = new GUI();
	
	public static void main(String[] args){
		GameManager gm = new GameManager();
		try {
			gm.startGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
