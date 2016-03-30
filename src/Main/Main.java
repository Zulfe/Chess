package Main;

import java.io.IOException;

public class Main {
	
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
