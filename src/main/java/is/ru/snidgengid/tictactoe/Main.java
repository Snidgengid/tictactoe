package is.ru.snidgengid.tictactoe;

import java.util.Arrays;

public class Board {

	private String board[BOARD_SIZE][BOARD_SIZE];

	public Board() {
		public static final int BOARD_SIZE = 3;
		this.board = new String[BOARD_SIZE][BOARD_SIZE];
	}

	public String getBoard() {
		return this.board;
	}
}
