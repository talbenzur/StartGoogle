package Week3.BehavioralPatterns;

public class Group implements Business {
    int id;
    int size;

    public Group(int id, int size) {
        this.id = id;
        this.size = size;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }
}
