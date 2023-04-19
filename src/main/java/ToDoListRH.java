import static spark.Spark.*;

public class ToDoListRH {
    public static void setRoutes()
    {
        delete("/removeToDo",ToDoListBL::removeToDo);
        post("/addToDo",ToDoListBL::addToDo);
        get("/user",ToDoListBL::getJsonUser);
        get("*", ServerToDoList::redirectToHome);
        System.out.println("Ui server initiated");

    }
}
