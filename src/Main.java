import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		GameTable game = new GameTable();
		
		for(int i = 0; i < 6; i++) {
			String line = in.nextLine();			
			game.addToMatrix(line, i);
		}
		
		game.determineWinner();
		
		if(game.isTableFull())
			System.out.println("EMPATE");
		else if(game.hasWinner())
			System.out.println("GANHOU " + game.getWinner() );
		else
			System.out.println("JOGANDO");
			
	}

	

}
