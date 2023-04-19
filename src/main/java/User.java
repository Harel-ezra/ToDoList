import java.util.List;

public class User {
    //    @BsonProperty("id")
//    @BsonId
    private int _id;
    private List<String> missions;
    private String name;

    public User() {
    }
    public User(int _id, List<String> missions, String name) {
        this._id=_id;
        this.missions=missions;
        this.name=name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMissions(List<String> missions) {
        this.missions = missions;
    }

    public List<String> getMissions() {
        return missions;
    }
    @Override
    public String toString()
    {
        return name+missions;
    }
}
