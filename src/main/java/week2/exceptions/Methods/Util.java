package week2.exceptions.Methods;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Util {

    public static Configuration ReadFile(String path) {
        Configuration configuration;
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            configuration = gson.fromJson(br, Configuration.class);

        } catch (FileNotFoundException e) {
            throw new IllegalStateException("file not found!!!!", e);
        }

        if (configuration == null) {
            throw new NullPointerException("null value return!!!");
        }

        return configuration;
    }
}
