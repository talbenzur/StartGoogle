package week3.behavioralPatterns;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Business> businesses = new ArrayList<>();
        businesses.add(new Asset(123, "Tal", 2.0));
        businesses.add(new Group(111, 10));
        businesses.add(new User(140, "Avi", "123456"));

        ExportJsonVisitor exportJsonVisitor = new ExportJsonVisitor();
        for (Business business : businesses) {
            business.accept(exportJsonVisitor);
        }

    }
}
