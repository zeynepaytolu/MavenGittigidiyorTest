import Base.DriverClient;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OpenWebSite {

    @Test
    public void openWebSite() throws InterruptedException {

        WebDriver driver = DriverClient.Chrome();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //www.gittigidiyor.com sitesi açılır.
        driver.navigate().to("https://www.gittigidiyor.com/");
        //Ana sayfanın açıldığı kontrol edilmek için bir süre beklenir.
        WebDriverWait wait = new WebDriverWait(driver, 8);//Sayfayı Bekletir.
        driver.manage().window().maximize();

        OpenLoginPage olp = new OpenLoginPage(driver);
        olp.openLoginPage();

        Assert.assertTrue(true);
    }
}
