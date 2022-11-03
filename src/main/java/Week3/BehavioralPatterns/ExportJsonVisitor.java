package Week3.BehavioralPatterns;

import com.google.gson.Gson;

public class ExportJsonVisitor implements Visitor {

    @Override
    public void visit(Asset asset) {
        System.out.println(convertToJson(asset));
    }

    @Override
    public void visit(Group group) {
        System.out.println(convertToJson(group));
    }

    @Override
    public void visit(User user) {
        System.out.println(convertToJson(user));
    }

    private String convertToJson(Object object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }

}
