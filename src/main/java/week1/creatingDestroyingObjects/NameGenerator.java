package week1.creatingDestroyingObjects;

public class NameGenerator {
    private static  String[] names;

    public static void setNames(String[] names) {
        NameGenerator.names = names;
    }

    public static String[] getNames() {
        return names;
    }
}
