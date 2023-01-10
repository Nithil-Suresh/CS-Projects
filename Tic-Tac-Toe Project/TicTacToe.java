import java.util.Scanner;

public class TicTacToe {
	
	private final char PLAYER_ONE = 'x';
	private final char PLAYER_TWO = 'o';
	
	Scanner inputReader;
	
	//private boolean solved;
	
	private char[] gameboard = {'1' ,'2', '3', '4', '5', '6', '7', '8', '9'};
	
	public TicTacToe() {
		inputReader = new Scanner(System.in);
		//solved = false;
	}
	// text version of tic tac toe
	// display game board that shows numbers in each of the squares
	// accept input from players 'x' and player 'o' and continue until someone gets three in a row
	public static void main (String[] args) {
		TicTacToe game = new TicTacToe();
		game.play();
	}
	
	public boolean isSolved() {
		//check to see if the same char is marked across an entire row, column, or diagonal
		if( gameboard[0] == gameboard [1] && gameboard[1] == gameboard[2]){
			return true;
		}
		return false;
	}
	
	public void play() {
		// play the game
		System.out.println("Play");
		//while the game is not solved
		while( isSolved() == false ) {
			showGameBoard();
			
			getInput(PLAYER_ONE);
			
			if( isSolved() == false )
				getInput(PLAYER_TWO);
		}
			// show the game board
		
			// get input from player x
			// get input from player o
		
		// show ending message
		showingEnd();
		
	}
	
	public void showGameBoard() {
		//displays current status of the board
		String gameScreen = "";
		for(int i = 0; i < gameboard.length; i++) {
			gameScreen += gameboard[i];
			if((i+1) % 3 == 0)
				gameScreen += "\n";
			else
				gameScreen += "|";
		}
		System.out.println(gameScreen);
	}
	
	public void getInput(char player) {
		// read the user input 
		// validate the chosen square is not taken
		// mark the square for that player
		int userInput = 0;
		do {
			showGameBoard();
			System.out.println("Player " + player +" please enter a number between 1 and 9 to mark a square");
			userInput = inputReader.nextInt();
		}while ( !isValidSquare( userInput ) );
		
		gameboard[userInput-1] = player;
		System.out.println(userInput);
	}
	
	public boolean isValidSquare(int input) {
		if(input < 1 || input > 9)
			return false;
		return true;
	}
	
	public void showingEnd() {
		System.out.println("GAME OVER");
	}

}
