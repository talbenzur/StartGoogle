package week1.ex1;


public class User {
    private String Name;
    private String Id;
    private boolean IsActivated;

    public User(String name, String id) {
        Name = name;
        Id = id;
    }

    public String getName() {
        return Name;
    }
    public String getId() {
        return Id;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setId(String id) {
        Id = id;
    }

}
