import java.util.ArrayList;

public class ToDoListBL {
    public static User getUserToDos(int userId) {
//        לא צריך fromMongo
        return ToDoListDAL.getToDosByUserName( userId);
    }

    public static String removeToDo( String toDo, int userId) {
        return ToDoListDAL.removeToDo( toDo, userId);
    }

    public static String addToDo( String toDo, int userId) {
        return ToDoListDAL.addToDo( toDo, userId);
    }

    public static String toDoIsDone(String toDo, int userId,boolean isDone) {
        return ToDoListDAL.toDoIsDone( toDo, userId,isDone);

    }

    public static String editToDo(String toDo, String editedToDo, int userId) {
        return ToDoListDAL.editToDo( toDo, editedToDo, userId);

    }

//    getAllUsers
    public static ArrayList<User> getAllUsers() {
        return ToDoListDAL.getAllUsersAtList();
    }


}

