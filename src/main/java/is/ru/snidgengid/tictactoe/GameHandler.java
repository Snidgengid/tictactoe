package is.ru.snidgengid.tictactoe;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.easymock.EasyMock;  



public class GameHandler {
	public Object newGame(Request req, Response res){	
		try{
			Database dbConn = new Database();
			ObjectMapper mapper = new ObjectMapper();
            Board b = new Board();            
            String jsonInString = mapper.writeValueAsString(b);
            dbConn.setBoard(b.getUUID(),jsonInString);
            res.status(200);
            res.type("text/json");
            return jsonInString;	        
      	}
      	catch (Exception e) {
      		return "Error creating new game";
      	}
	}
}