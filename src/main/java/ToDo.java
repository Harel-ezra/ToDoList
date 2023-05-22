public class ToDo {
    private String name;
    private Boolean isDone;

    public ToDo() {
    }
    public ToDo(String name, Boolean isDone)
    {
        this.isDone=isDone;
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return '{' +
                "name='" + name + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
