package gmibank.com.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationSetter {

    public static void setProperty(String path, String configKey, String configValue){
        path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            properties.setProperty(configKey,configValue);
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            properties.store(fileOutputStream,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
