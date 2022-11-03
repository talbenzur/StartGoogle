package Week2.Exceptions.Methods;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    Map<String, String> configuration;


    public Configuration(Map<String, String> configuration) {
        this.configuration = configuration;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "configuration=" + configuration +
                '}';
    }

    public String getValueByKey(String key) {
        if (configuration != null) {
            if (configuration.containsKey(key)) {
                return configuration.get(key);
            } else {
                throw new IllegalArgumentException("key does not exist");
            }
        } else {
            throw new NullPointerException("configuration is null!!!");
        }
    }
}
