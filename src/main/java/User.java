import java.util.List;

public class User {

    private int _id;
    private List<ToDo> todos;
    private String name;

    public User() {
    }

    public User(int id, List<ToDo> todos, String name) {
        this._id = id;
        this.todos = todos;
        this.name = name;
    }

    public void setId(int id) {
        this._id = id;
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTodos(List<ToDo> todos) {
        this.todos = todos;
    }

    public List<ToDo> getTodos() {
        return todos;
    }

    @Override
    public String toString() {
        return name + todos;
    }
}
