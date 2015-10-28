package is.ru.snidgengid.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.UUID;


public class MainTest {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.snidgengid.tictactoeTest");
	}
	
	@Test
	public void testEmptyNewBoard() {
		String[][] emptyBoard = new String[3][3];
		Board newBoard = new Board();
		assertEquals(emptyBoard, newBoard.getBoard());
	}

	@Test
	public void testEnsureUUIDset() {
		Board board = new Board();
		UUID uuidFromString = UUID.fromString(board.getUUID());
		assertEquals(uuidFromString.toString(),board.getUUID());
	}

}
