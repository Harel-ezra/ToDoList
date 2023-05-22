import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class ToDoListRH {
    public static void setRoutes() {
        //   זה לא delete זה משהו שמוחק מהדיבי
        put("/removeToDo", ToDoListRH::removeToDo);

        post("/addToDo", ToDoListRH::addToDo);
        put("/editToDo", ToDoListRH::editToDo);
        put("/toDoIsDone", ToDoListRH::setTodoIsDone);
        get("/toDoList", ToDoListRH::getToDoListUser);
        get("/allUsers", ToDoListRH::getAllUsers);

        System.out.println("Ui server initiated");
    }


    //    getAllUsers
    private static String getAllUsers(Request request, Response response) {
        return new Gson().toJson(ToDoListBL.getAllUsers());
    }

    //גם פה בלי גייסון
    public static String getToDoListUser(Request request, Response response) {
        int userId = Integer.parseInt(request.queryParams("id"));
//        לא צריך להיות ספציפי כלכך אני יודע שזה מונגו
        return new Gson().toJson(ToDoListBL.getUserToDos(userId));
    }

    public static String removeToDo(Request request, Response response) {
        JsonObject requestBody = new JsonParser().parse(request.body()).getAsJsonObject();
        String toDoName = requestBody.get("toDo").getAsString();
        int userId = requestBody.get("id").getAsInt();
        return ToDoListBL.removeToDo(toDoName, userId);
    }

    public static String addToDo(Request request, Response response) {
//        תשנה את השמות כאן שיהיה כמו מה ששניתי לך בremoveTodo ובכל האחרים שהשתמשת בשמות האלה
        JsonObject requestBody = new JsonParser().parse(request.body()).getAsJsonObject();
        String toDoName = requestBody.get("toDo").getAsString();
        int userId = requestBody.get("id").getAsInt();
        return ToDoListBL.addToDo(toDoName, userId);
    }

    public static String editToDo(Request request, Response response) {
        JsonObject requestBody = new JsonParser().parse(request.body()).getAsJsonObject();
        String toDoName = requestBody.get("toDo").getAsString();
        String editedToDo = requestBody.get("editedToDo").getAsString();
        int userId = requestBody.get("id").getAsInt();
        return ToDoListBL.editToDo(toDoName, editedToDo, userId);
    }

//    setTodoIsDone/ updateTodoIsDone / changeTodoIsDone
    public static String setTodoIsDone(Request request, Response response) {
        JsonObject requestBody = new JsonParser().parse(request.body()).getAsJsonObject();
        String toDoName = requestBody.get("toDo").getAsString();
        int userId = requestBody.get("id").getAsInt();
        boolean isDone = requestBody.get("isDone").getAsBoolean();
        return ToDoListBL.toDoIsDone(toDoName, userId, isDone);

    }
}
