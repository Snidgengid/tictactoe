package is.ru.snidgengid.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.cthul.matchers.CthulMatchers.*;
import org.junit.Test;
import org.junit.Before;
import spark.Request;
import spark.Response;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.util.UUID;



public class DatabaseTest{
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.snidgengid.tictactoeTest");
	}

	@Before
    public void populateRedisWithTestData() {
    	try {
			Database dbConn = new Database();
			String boardJSON = "{\"board\":[[null,null,null],[null,null,null],[null,null,null]],\"uuid\":\"636e4b86-ec96-4ab9-b044-ed7713076cf3\",\"isWon\":false,\"isDraw\":false,\"whoWon\":null,\"nextPlayer\":\"X\"}";
			String boardUUID = "636e4b86-ec96-4ab9-b044-ed7713076cf3";
			dbConn.setBoard(boardUUID,boardJSON);
		}
		catch (Exception ce) {
			fail("Exception: " + ce.getMessage());
		}
    }

	@Test
	public void testWriteBoardToRedis() {
		try {
			Database dbConn = new Database();
			String boardJSON = "{\"board\":[[null,null,null],[null,null,null],[null,null,null]],\"uuid\":\"636e4b86-ec96-4ab9-b044-ed7713076cf2\",\"isWon\":false,\"isDraw\":false,\"whoWon\":null,\"nextPlayer\":\"X\"}";
			String boardUUID = "636e4b86-ec96-4ab9-b044-ed7713076cf2";
			assertEquals(dbConn.setBoard(boardUUID,boardJSON),true);
		}
		catch (Exception ce) {
			fail("Exception: " + ce.getMessage());
		}

	}

	@Test
	public void testReadBoardFromRedis() {
		try {
			Database dbConn = new Database();
			String expectedBoardJSON = "{\"board\":[[null,null,null],[null,null,null],[null,null,null]],\"uuid\":\"636e4b86-ec96-4ab9-b044-ed7713076cf3\",\"isWon\":false,\"isDraw\":false,\"whoWon\":null,\"nextPlayer\":\"X\"}";
			String expectedBoardUUID = "636e4b86-ec96-4ab9-b044-ed7713076cf3";
			assertEquals(dbConn.getBoard(expectedBoardUUID),expectedBoardJSON);
		}
		catch (Exception ce) {
			fail("Exception: " + ce.getMessage());
		}
	}
}