package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClient {

    public static WebDriver Chrome()
    {
        String name ="webdriver.chrome.driver";
        String path = "C:\\Users\\ZeynepAytl\\Desktop\\chromedriver_win32/chromedriver.exe";
        System.setProperty(name,path);
        return new ChromeDriver();
    }


}
