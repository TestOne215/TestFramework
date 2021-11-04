package Framework.Commons;

import java.io.FileInputStream;
import java.util.Properties;

public class GlobalConfig {
    private static GlobalConfig config = null; //no object created for this class
    private Properties prop;
    private FileInputStream fis;

    //no outside class can access this method
    private GlobalConfig(){
        try{

            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
            prop.load(fis);
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static GlobalConfig getProperties(){//it should be public static
        if(config==null){
            config = new GlobalConfig();
        }
        return config;
    }

    public String get(String key){
        return prop.getProperty(key); //returns the value
    }





    public void set(String key,String value){
         prop.setProperty(key,value);
    }


}
