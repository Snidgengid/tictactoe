package is.ru.snidgengid.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.cthul.matchers.CthulMatchers.*;
import org.junit.Test;
import org.junit.Before;
import java.util.UUID;
import java.util.Map;
import java.util.Collections;
import java.lang.reflect.Field;


public class WebTest{
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.snidgengid.tictactoeTest");
	}	

	@Test
    public void getHerokuPort() {    	
    	int expectedPort = 4567;
    	int herokuPort = new Web().getHerokuAssignedPort();
    	assertEquals(expectedPort,herokuPort);  
    }

}