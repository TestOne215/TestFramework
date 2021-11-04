package Day7;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_inheritance {
    FirefoxDriver driver;
    void launchApp(String url){
        System.setProperty("webdriver.gecko.driver","C:\\Training\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
    }
    void tearDown(){
        driver.quit();
    }
}
