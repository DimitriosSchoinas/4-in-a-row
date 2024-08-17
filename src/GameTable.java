
public class GameTable {

	private static final int ROWS_NUM = 6;
	private static final int COLS_NUM = 7;
	
	private char[][] gameMatrix;
	private boolean gameEnded;
	private boolean hasWinner;
	private char winner;
	
	public GameTable() {
		
		gameMatrix = new char[ROWS_NUM][COLS_NUM];
		gameEnded = false;
		hasWinner = false;
		winner = 'O';
	}
	
	public void addToMatrix(String line, int lineNumber) {
		
		char[] tableCharacters = line.toCharArray();
		
		for(int i = 0; i < tableCharacters.length; i++)
			gameMatrix[lineNumber][i] = tableCharacters[i];
	}
	public boolean hasGameEnded() {
		return gameEnded;
	}
	
	public boolean isTableFull() {
		
		int i = 0;
		
		while(i < gameMatrix[0].length && gameMatrix[0][i] != '.')
			i++;
		
		return i ==  gameMatrix[0].length;
	}

	public boolean hasWinner() {
		
		return hasWinner;
	}
	public void determineWinner() {
		
		for(int i = 0; i < gameMatrix.length; i ++) {
			for(int j  = 0; j < gameMatrix[0].length; j++) {
				if(gameMatrix[i][j] == 'O' || gameMatrix[i][j] == 'X') {
					if(j < gameMatrix[0].length - 3)
						if(gameMatrix[i][j] == gameMatrix[i][j+1] && gameMatrix[i][j] == gameMatrix[i][j+2] && gameMatrix[i][j] == gameMatrix[i][j+3]) {
							hasWinner = true;
							winner = gameMatrix[i][j];
						}
					if(i < gameMatrix.length - 3)
						if(gameMatrix[i][j] == gameMatrix[i+1][j] && gameMatrix[i][j] == gameMatrix[i+2][j] && gameMatrix[i][j] == gameMatrix[i+3][j]) {
							hasWinner = true;
							winner = gameMatrix[i][j];
						}	
					if(i < gameMatrix.length - 3 && j >= 3)
						if(gameMatrix[i][j] == gameMatrix[i+1][j-1] && gameMatrix[i][j] == gameMatrix[i+2][j-2] && gameMatrix[i][j] == gameMatrix[i+3][j-3]) {
							hasWinner = true;
							winner = gameMatrix[i][j];
						}
					if(i < gameMatrix.length - 3 && j < gameMatrix[0].length - 3)
						if(gameMatrix[i][j] == gameMatrix[i+1][j+1] && gameMatrix[i][j] == gameMatrix[i+2][j+2] && gameMatrix[i][j] == gameMatrix[i+3][j+3]) {
							hasWinner = true;
							winner = gameMatrix[i][j];
						}
				}
			}
		}
	
	}

	public char getWinner() {
		return winner;
	}
	
}
