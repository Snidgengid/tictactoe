package is.ru.snidgengid.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.cthul.matchers.CthulMatchers.*;
import org.junit.Test;
import spark.Request;
import spark.Response;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.util.UUID;


public class JedisFactoryTest{
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.snidgengid.tictactoeTest");
	}

	@Test
	public void testWriteReadToRedis() {
		Jedis conn = JedisFactory.getInstance().getJedisPool().getResource();
		String testString = UUID.randomUUID().toString();
		conn.set("testWriteReadToRedis",testString);
		String resultString = conn.get("testWriteReadToRedis");
		assertEquals(testString,resultString);
	}
}