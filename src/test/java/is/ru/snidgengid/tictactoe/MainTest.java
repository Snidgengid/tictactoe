package is.ru.snidgengid.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MainTest {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.snidgengid.tictactoeTest");
	}
	
	@Test
	public void test_getID() {
		assertEquals(0, Main.getID());
	}
}
