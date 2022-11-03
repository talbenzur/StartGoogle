package Week2.Exceptions;

import Week2.Exceptions.Methods.Configuration;
import Week2.Exceptions.Methods.Util;

public class Main {
    public static void main(String[] args) {
        Configuration configurationFile = Util.ReadFile("C:\\Users\\tbz19\\Documents\\Start@Google\\java\\src\\Week2\\Exceptions\\Methods\\configurationFile.json");
        Configuration configurationFile2 = Util.ReadFile("C:\\Users\\tbz19\\Downloads\\package.json");


        System.out.println(configurationFile);
        System.out.println(configurationFile2);

        String key = "gatewaySettings";
        System.out.println("config value of:" + key + "is:" + configurationFile.getValueByKey(key));

    }
}
