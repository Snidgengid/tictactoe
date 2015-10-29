package is.ru.snidgengid.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.routematch.RouteMatch;


public class GameHandlerTest {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.snidgengid.tictactoeTest");
	}	

	RouteMatch match = new RouteMatch(null, "/", "/", "text/html");


	@Test
	public void testNewGameReturnsCorrectString() {
		GameHandler game = new GameHandler();
		Response res = null;
		Request req = null;
		String response = (String)game.newGame(req, res);
		String expectedResponse = "{\"board\":[[null,null,null],[null,null,null],[null,null,null]],\"uuid\":\"636e4b86-ec96-4ab9-b044-ed7713076cf2\",\"isWon\":false,\"isDraw\":false,\"whoWon\":null,\"nextPlayer\":\"X\"}";
		assertEquals(response,expectedResponse);
	}

}
