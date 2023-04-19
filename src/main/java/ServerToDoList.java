import spark.Request;
import spark.Response;
import spark.Spark;

import static spark.Spark.*;

public class ServerToDoList {
    public static void main(String[] args) {
        Spark.staticFiles.location("/public");
        setupCores();
        ToDoListRH.setRoutes();
    }

    public static void setupCores() {
        after((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers: Origin"," Content-Type, Accept, Authorization, X-Request-With");
            response.header("Access-Control-Allow-Credentials", "true");
            response.type("application/json");
        });

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
    }



    public static String redirectToHome(Request request, Response response) {
        response.redirect("");
        System.out.println("redirect to home");
        return null;
    }
}
