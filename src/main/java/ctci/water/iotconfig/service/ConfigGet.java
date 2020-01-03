package ctci.water.iotconfig.service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigGet {
    //根据key读value
    //filePath = ./src/main/resources/config.properties
    public static String GetValueByKey(String filePath,String key) {
        Properties ps = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            ps.load(in);
            String value = ps.getProperty(key);
            return value;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
