package Day17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertiefiles {
    public static Properties prop;
    public static String getConfigValue(String key) throws IOException {
        if(prop==null) {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
            prop.load(fis);
            fis.close();
        }
        //String url = prop.getProperty("QA");
        return  prop.getProperty(key);
    }
}
