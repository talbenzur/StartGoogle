package week3.behavioralPatterns;

public interface Visitor {
    void visit(Asset asset);

    void visit(Group group);

    void visit(User user);

}
