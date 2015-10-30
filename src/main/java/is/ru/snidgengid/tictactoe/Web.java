package is.ru.snidgengid.tictactoe;

import static spark.Spark.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Request;
import spark.Response;
import spark.Route;


public class Web {

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        get("/newGame", (req, res) -> new GameHandler().newGame(req,res));
        put("/action", (req, res) -> new GameHandler().action(req,res));

    }


    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}

