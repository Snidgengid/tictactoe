package is.ru.snidgengid.tictactoe;

import java.util.Arrays;
import java.util.UUID;

/**
* Implementation of game logic for TicTacToe
**/
public class Board {
	private String board[][];
	private String uuid;
	private final int BOARD_SIZE = 3;
	private Boolean isWon;
	private Boolean isDraw;
	private String whoWon;
	private String nextPlayer;

	/**
	* Default constructor for Board, creates a new initialized game
	**/
	public Board() {
		this.board = new String[BOARD_SIZE][BOARD_SIZE];
		this.uuid = UUID.randomUUID().toString();
		this.isWon = false;
		this.isDraw = false;
		this.whoWon = null;
		this.nextPlayer = "X";
	}

	/**
	* Checks if game is won or draw and switches players
	*
	*
	*/
	public void checkGame() {
		checkIfGameIsWonOrDraw();
		switchPlayer();
	}

	/**
	* Check winning criter for horizontal, vertical and diagonal scenarios and checks if a draw has been reached
	*/
	private void checkIfGameIsWonOrDraw() {
		//This loop checks for a winner in horizontal lines
		for (int i = 0; i < BOARD_SIZE; i++) {
			if ( (this.getElement(i, 0) != null) &&
			        this.getElement(i, 0).equals(this.getElement(i, 1)) &&
			        this.getElement(i, 1).equals(this.getElement(i, 2)) ) {
				setIsWon(true);
				setWhoWon(this.getElement(i, 0));
				return;
			}
		}
		//This loop checks for a winner in vertical lines
		for (int i = 0; i < BOARD_SIZE; i++) {
			if ( (this.getElement(0, i) != null) &&
			        this.getElement(0, i).equals(this.getElement(1, i)) &&
			        this.getElement(1, i).equals(this.getElement(2, i)) ) {
				setIsWon(true);
				setWhoWon(this.getElement(0, i));
				return;
			}
		}
		//check for a diagonal winning line
		if (this.getElement(0, 0) != null &&
		        this.getElement(0, 0).equals(this.getElement(1, 1)) && 
		        this.getElement(1, 1).equals(this.getElement(2, 2)) ) {
			setIsWon(true);
			setWhoWon(this.getElement(0, 0));
			return;
		}
		//check for a diagonal winning line
		if (this.getElement(0, 2) != null &&
		        this.getElement(0, 2).equals(this.getElement(1, 1)) &&
		        this.getElement(1, 1).equals(this.getElement(2, 0)) ) {
			setIsWon(true);
			setWhoWon(this.getElement(0, 2));
			return;
		}

		//check if every cell is checked if so it is a draw
		int counter = 0;
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (board[i][j] != null)
					counter++;
			}
		if (counter == 9)
			setIsDraw(true);
	}

	/**
	* Switch the players
	* Toggles the value of nextPlayer between X and O
	*/
	private	void switchPlayer() {
		if (this.nextPlayer.equals("X"))
			this.nextPlayer = "O";
		else
			this.nextPlayer = "X";
	}

	/**
	* Set element on TicTacToe board
	* Checks if the move is valid and proceeds to set the elements value
	*
	* @param i (Row)
	* @param j (Column)
	* @param value (X or O)
	* @throws RuntimeException
	*/
	public void setElement(int i, int j, String value) {
		if (checkIfMoveValid(i, j))
			this.board[i][j] = value;
		else
			throw new RuntimeException("Cell already taken! Please try again");
	}

	/**
	* checks if the cell is already checked if so it is not a valid move
	*
	* @param int i Which row the element is in
	* @param int j Which column the elemnt is in 
	* @retun Boolean
	*/
	private boolean checkIfMoveValid(int i, int j) {
		if (this.board[i][j] != null)
			return false;
		else
			return true;
	}

	/**
	* Returns next player
	* @return String 
	*/
	public String getNextPlayer() {
		return this.nextPlayer;
	}

	/**
	* Set whoWon
	*
	* @param winner 
	*/
	public void setWhoWon(String winner) {
		this.whoWon = winner;
	}

	/**
	* Get whoWon
	* @return String
	**/
	public String getWhoWon() {
		return this.whoWon;
	}

	/**
	* Get isDraw
	* @return Boolean 
	**/
	public boolean getIsDraw() {
		return this.isDraw;
	}

	/**
	* Get setIsDraw
	* @param  isDraw 
	**/
	public void setIsDraw(boolean isDraw) {
		this.isDraw = isDraw;
	}

	/**
	* Get isWon
	* @return boolean 
	**/
	public boolean getIsWon() {
		return this.isWon;
	}

	/**
	* Set isWon
	* @param isWon
	**/
	public void setIsWon(Boolean isWon) {
		this.isWon = isWon;
	}

	/**
	* Get Board
	* @return String[][] 
	**/
	public String[][] getBoard() {
		return this.board;
	}

	/**
	* Get UUID
	* @return String 
	**/
	public String getUUID() {
		return this.uuid;
	}

	/**
	* Get element from board
	* @param i Row of element to fetch
	* @param j Column of element to fetch
	* @return board 
	**/
	public String getElement(int i, int j) {
		return this.board[i][j];
	}
}
