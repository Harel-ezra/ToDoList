import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Request;
import spark.Response;

public class ToDoListBL {
    public static String getJsonUser(Request request, Response response) {
        String userName = request.queryParams("name");
        return new Gson().toJson(getUserFromMongo(userName));
    }

    public static User getUserFromMongo(String userName) {
        return ToDoListDAL.getMissionsFromMongoByUserName(userName);
    }

    public static String removeToDo(Request request, Response response) {
        JsonObject json = new JsonParser().parse(request.body()).getAsJsonObject();
        String userName = json.get("name").getAsString();
        String toDo = json.get("toDo").getAsString();
        return ToDoListDAL.removeToDo(userName, toDo);
    }

    public static String addToDo(Request request, Response response) {
        JsonObject json = new JsonParser().parse(request.body()).getAsJsonObject();
        String userName = json.get("name").getAsString();
        String toDo = json.get("toDo").getAsString();
        return ToDoListDAL.addToDo(userName, toDo);
    }
}

