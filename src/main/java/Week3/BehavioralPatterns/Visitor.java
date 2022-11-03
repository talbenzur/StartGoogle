package Week3.BehavioralPatterns;

public interface Visitor {
    void visit(Asset asset);

    void visit(Group group);

    void visit(User user);

}
